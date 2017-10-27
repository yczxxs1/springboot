package com.google.business.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.business.dao.LicenseDAO;
import com.google.business.dao.LicensePhotoDAO;
import com.google.business.dao.LicenseTypeDAO;
import com.google.business.dao.MessageDAO;
import com.google.business.dao.UavDAO;
import com.google.business.dao.UserDAO;
import com.google.business.model.LicenseEntity;
import com.google.business.model.LicensePhotoEntity;
import com.google.business.model.LicenseTypeEntity;
import com.google.business.model.MessageEntity;
import com.google.business.model.UavEntity;
import com.google.business.model.User;
import com.google.business.service.LicenseService;
import com.google.business.util.fastDFS.FastDFSFileUtils;
import com.google.business.util.jpush.Extra;
import com.google.business.util.jpush.Push;
import com.google.common.exception.ServiceException;

@Service
public class LicenseServiceImpl implements LicenseService {

	@Autowired
	private LicenseDAO licenseDao;

	@Autowired
	private LicensePhotoDAO licensePhotoDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private LicenseTypeDAO licenseTypeDAO;

	@Autowired
	private MessageDAO messageDAO;

	@Autowired
	private UavDAO uavDAO;

	@Autowired
	private LicenseDAO licenseDAO;

	@Override
	@Transactional
	public void saveOrUpdate(LicenseEntity licenseEntity, List<File> files) throws Exception {
		// TODO Auto-generated method stub
		try {
			String licenseId = licenseEntity.getId();
			String userId = licenseEntity.getUserId();
			if ("".equals(licenseId) || licenseId == null) {
				licenseDao.insertSelective(licenseEntity);
			} else {
				licenseEntity.setId(licenseId);
				licenseEntity.setReview("0");
				licenseDao.updateByPrimaryKeySelective(licenseEntity);
				LicensePhotoEntity lpe = new LicensePhotoEntity();
				lpe.setLicenseId(licenseId);
				List<LicensePhotoEntity> list = licensePhotoDAO.selectLicensePhotoList(lpe);
				// 删除文件服务器上的图片
				for (LicensePhotoEntity lp : list) {
					FastDFSFileUtils.deleteFileToDfs(lp.getPhotoUrl());
					// 删库
					licensePhotoDAO.deleteByPrimaryKey(lp);
				}

			}
			for (File file : files) {
				String photoUrl = FastDFSFileUtils.uploadFileToDfs(file);
				licensePhotoDAO
						.insertSelective(new LicensePhotoEntity(licenseEntity.getId(), photoUrl, userId, new Date()));
			}
			/*
			 * User uie = userDAO.selectByPrimaryKey(userId);
			 * 
			 * if (uie != null) { User user1=new User(); user1.setId(userId);
			 * user1.setUserStatus("1");
			 * userDAO.updateByPrimaryKeySelective(user1); }else{ throw new
			 * ServiceException("用户不存在"); }
			 */
		} finally {
			// TODO: handle finally clause
			for (File file : files) {
				file.delete();
			}
		}

	}

	@Override
	@Transactional
	public void deleteSelective(LicenseEntity licenseEntity) {
		int num = licenseDao.deleteByPrimaryKey(licenseEntity);
		if (num == 0) {
			throw new ServiceException("用户不存在！");
		}

		// 删除图片
		LicensePhotoEntity licensePhotoEntity = new LicensePhotoEntity();
		licensePhotoEntity.setLicenseId(licenseEntity.getId());
		List<LicensePhotoEntity> lpeList = licensePhotoDAO.selectLicensePhotoList(licensePhotoEntity);
		for (LicensePhotoEntity lpe : lpeList) {
			licensePhotoDAO.deleteByPrimaryKey(lpe);
		}

	}

	@Override
	public void updateSelective(LicenseEntity licenseEntity) {
		licenseEntity.setLicenseStatus("0");
		licenseDao.updateByPrimaryKeySelective(licenseEntity);
		LicenseEntity licenseEntity1 = licenseDao.selectByPrimaryKey(licenseEntity);
		String belongId = licenseEntity1.getUserId();
		// 判断该用户 是否存在一个 状态为正常并且审核通过的无人机或者状态为正常并且审核通过的无人机
		// 如果存在，则不改变该用户的认证状态，如果不存在，则改变改用的认证状态为未认证（2）
		UavEntity uav2 = new UavEntity();
		uav2.setStatus("1");
		uav2.setReview("2");
		uav2.setBelongId(belongId);
		int count1 = uavDAO.selectUavList_count(uav2);
		LicenseEntity license = new LicenseEntity();
		license.setUserId(belongId);
		license.setLicenseStatus("1");
		license.setReview("2");
		int count2 = licenseDAO.selectLicenseList_count(license);
		if (count1 >= 1 || count2 >= 1) {
			// 符合认证条件，不做改变
		} else {
			// 不符合认账条件，将users表中的userstatus改为2
			User user2 = new User();
			user2.setId(belongId);
			user2.setUserStatus("2");
			userDAO.updateByPrimaryKeySelective(user2);
		}

	}

	@Override
	@Transactional
	public List<LicenseEntity> getLicenseList(LicenseEntity licenseEntity) {
		// 传userId
		if (licenseEntity.getUserId() == null) {
			throw new ServiceException("非法！");
		}
		licenseEntity.setLicenseStatus("1");// 显示状态是正常的执照
		List<LicenseEntity> list = licenseDao.selectLicenseList(licenseEntity);
		for (LicenseEntity le : list) {
			if (le.getValidDate().before(new Date())) {
				le.setExpired(true);
			} else {
				le.setExpired(false);
			}
		}
		// 查询证件列表的第一张照片
		for (LicenseEntity le : list) {
			LicensePhotoEntity lpe = licensePhotoDAO.selectLicensePhotoFirst(le.getId());
			if (lpe != null)
				le.setPhotoUrl(lpe.getPhotoUrl());
		}
		return list;
	}

	@Override
	public List<LicenseEntity> getLicenseListByAreaId(LicenseEntity licenseEntity) {
		// 传userId
		licenseEntity.setLicenseStatus("1");// 显示状态是正常的执照
		String areaId[]=null;
		String areaIds=licenseEntity.getAreaId();
		if(!StringUtils.isEmpty(areaIds)){
			areaId=areaIds.split(",");
		}
		List<LicenseEntity> list = licenseDao.selectLienseListByAreaId(licenseEntity,areaId);
		for (LicenseEntity le : list) {
			if (le.getValidDate().before(new Date())) {
				le.setExpired(true);
			} else {
				le.setExpired(false);
			}
		}
		return list;
	}

	@Override
	public LicenseEntity getLicenseList_Count(LicenseEntity licenseEntity) {
		// 传userId
		LicenseEntity lEntity = licenseDao.selectLicenseOne(licenseEntity);
		if (lEntity == null) {
			throw new ServiceException("执照不存在！");
		} else {
			LicensePhotoEntity licensePhotoEntity = new LicensePhotoEntity();
			licensePhotoEntity.setLicenseId(licenseEntity.getId());
			List<LicensePhotoEntity> licensePhotoList = licensePhotoDAO.selectLicensePhotoList(licensePhotoEntity);
			lEntity.setLicensePhotoList(licensePhotoList);
		}
		return lEntity;
	}

	@Override
	public List<LicenseTypeEntity> getLicenseType(LicenseTypeEntity licenseTypeEntity) {
		List<LicenseTypeEntity> licenseTypelList = licenseTypeDAO.selectLicenseTypeList(licenseTypeEntity);
		if (licenseTypelList == null) {
			throw new ServiceException("不存在！");
		}
		return licenseTypelList;
	}

	@Override
	@Transactional
	public void review(LicenseEntity licenseEntity) {
		licenseDao.updateByPrimaryKeySelective(licenseEntity);
		String review = licenseEntity.getReview();
		String userId = licenseEntity.getUserId();
		String content = " ";
		MessageEntity me = null;
		if ("2".equals(review)) {
			// 变更用户状态
			if (userDAO.selectByPrimaryKey(userId) != null) {
				User user = new User();
				user.setUserStatus("1");
				user.setId(userId);
				userDAO.updateByPrimaryKeySelective(user);
			}
			me = new MessageEntity("证书审核通过！", content, "2", new Date(), "1", userId);
			messageDAO.insertMessage(me);
			// 推送
			Push.testSendPushByAlias("证书审核通过！", userId, new Extra().setMessageId(me.getId()));
		} else if ("1".equals(review)) {
			content = "理由:" + licenseEntity.getReviewReason();
			if (!"".equals(licenseEntity.getReviewRemark())) {
				content = content + "\n" + "备注:" + licenseEntity.getReviewRemark();
			}
			me = new MessageEntity("证书审核未通过！", content, "2", new Date(), "1", userId);
			messageDAO.insertMessage(me);
			// 推送
			Push.testSendPushByAlias("证书审核不通过！", userId, new Extra().setMessageId(me.getId()));
		} else {
			throw new ServiceException("非法！");
		}
	}

	@Override
	@Transactional
	public void deleteBatch(List<String> list) {
		// TODO Auto-generated method stub
		for (String licenseId : list) {
			LicenseEntity licenseEntity = new LicenseEntity();
			licenseEntity.setId(licenseId);
			licenseDao.deleteByPrimaryKey(licenseEntity);
			// 删除图片
			LicensePhotoEntity licensePhotoEntity = new LicensePhotoEntity();
			licensePhotoEntity.setLicenseId(licenseEntity.getId());
			List<LicensePhotoEntity> lpeList = licensePhotoDAO.selectLicensePhotoList(licensePhotoEntity);
			for (LicensePhotoEntity lpe : lpeList) {
				licensePhotoDAO.deleteByPrimaryKey(lpe);
			}
		}
	}

}
