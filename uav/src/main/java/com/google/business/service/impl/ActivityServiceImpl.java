package com.google.business.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.business.conversion.ActivityConversion;
import com.google.business.dao.ActUavDAO;
import com.google.business.dao.ActivityDAO;
import com.google.business.dao.InsurancePhotoDAO;
import com.google.business.dao.MessageDAO;
import com.google.business.dao.OrgPhotoDAO;
import com.google.business.dao.SecurePhotoDAO;
import com.google.business.dao.UserDAO;
import com.google.business.dto.ActivityDTO;
import com.google.business.model.ActUav;
import com.google.business.model.Activity;
import com.google.business.model.InsurancePhoto;
import com.google.business.model.MessageEntity;
import com.google.business.model.OrgPhoto;
import com.google.business.model.SecurePhoto;
import com.google.business.service.ActivityService;
import com.google.business.util.fastDFS.FastDFSFileUtils;
import com.google.business.util.jpush.Extra;
import com.google.business.util.jpush.Push;
import com.google.common.exception.ServiceException;

@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityDAO actDAO;
	@Autowired
	private SecurePhotoDAO secPhDAO;
	@Autowired
	private OrgPhotoDAO orgPhDAO;
	@Autowired
	private ActUavDAO actUavDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private InsurancePhotoDAO ispDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private ActivityConversion activityConversion;

	@Override
	@Transactional
	public void createActivity(Activity activity, List<File> files1, List<File> files2) throws Exception {
		// TODO Auto-generated method stub
		try {
			String activityId = activity.getId();
			String userId = activity.getUserId();
			if (activityId == null || "".equals(activityId)) {
				throw new ServiceException("缺少活动Id！");
			}
			if (userId == null || "".equals(userId)) {
				throw new ServiceException("非法！");
			}
			if (actUavDAO.selectActUavByActId(activityId).isEmpty()) {
				throw new ServiceException("缺少活动无人机！");
			}
			if (!"1".equals(userDAO.selectByPrimaryKey(userId).getUserType())) {
				throw new ServiceException("只有单位可以申请活动！");
			}
			// 主办方资质照片
			for (File file : files1) {
				String photoUrl = FastDFSFileUtils.uploadFileToDfs(file);// 上传文件服务器
				orgPhDAO.insertSelective(new OrgPhoto(activityId, photoUrl, new Date()));// 图片地址入库
			}
			// 安全许可材料照片
			for (File file : files2) {
				String photoUrl = FastDFSFileUtils.uploadFileToDfs(file);// 上传文件服务器
				secPhDAO.insertSelective(new SecurePhoto(activityId, photoUrl, new Date()));// 图片地址入库
			}

			actDAO.insertActivity(activity);
		} finally {
			// TODO: handle finally clause
			for (File file : files1) {
				file.delete();
			}
			for (File file : files2) {
				file.delete();
			}
		}
	}
	
	//内部调用
	@Override
	public void delAct(String id) {
		// TODO Auto-generated method stub
		// 删除SecurePhoto
		List<SecurePhoto> scPhotos = secPhDAO.selectByActivityId(id);
		for (SecurePhoto sp : scPhotos) {
			FastDFSFileUtils.deleteFileToDfs(sp.getUrl());
			secPhDAO.deleteByPrimaryKey(sp.getId());
		}
		// 删除OrgPhoto
		List<OrgPhoto> orgPhotos = orgPhDAO.selectByActivityId(id);
		for (OrgPhoto op : orgPhotos) {
			FastDFSFileUtils.deleteFileToDfs(op.getUrl());
			orgPhDAO.deleteByPrimaryKey(op.getId());
		}
		// 删除无人机和无人机保单图片
		List<ActUav> actUavs = actUavDAO.selectActUavByActId(id);
		for (ActUav au : actUavs) {
			String actUavId = au.getId();
			List<InsurancePhoto> InsurancePhotos = ispDAO.selectByActUavId(actUavId);
			for (InsurancePhoto ip : InsurancePhotos) {
				FastDFSFileUtils.deleteFileToDfs(ip.getUrl());
				ispDAO.deleteByPrimaryKey(ip.getId());
			}
			actUavDAO.deleteByPrimaryKey(actUavId);
		}
		actDAO.deleteActivity(id);
	}
	
    //活动删除
	@Override
	@Transactional
	public void delActivity(String id) {
		delAct(id);
	}

	//活动审核
	@Override
	public void reviewActivity(Activity activity) {
		// TODO Auto-generated method stub
		int act;
		Activity act1= actDAO.selectById(activity.getId());
		String content = "";
		MessageEntity me = null;
		//判断审核内容
		if ("1".equals(activity.getReview())) {
		    act = actDAO.updateActivity(activity);
		    content="备注：" + activity.getRemarks();
			me = new MessageEntity("活动审核不通过！", content, "2", new Date(), "1", act1.getUserId());
		}
		else if ("2".equals(activity.getReview())) {
			int a = actUavDAO.selectActUavReviewCount(activity.getId());
			if (a==0) {
				throw new ServiceException("该活动下没有合法的无人机！");
			}else {
				act = actDAO.updateActivity(activity);
				me = new MessageEntity("活动审核通过！", content, "2", new Date(), "1", act1.getUserId());
				if (actUavDAO.selectActUavReviewCount0(activity.getId())>0) {
					throw new ServiceException("请尽快完成当前活动下所有无人机审核！");
				}
			}
		}else {
			throw new ServiceException("review非法！");
		}
		if (act == 0) {
			throw new ServiceException("活动审核失败！");
		}
		messageDAO.insertMessage(me);
		try {
			Push.testSendPushByAlias(content, act1.getUserId(), new Extra().setMessageId(me.getId()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<Activity> getActList(Activity activity) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		ActivityDTO activityDTO = modelMapper.map(activity, ActivityDTO.class);
		List<Activity> list = null;
		if ("2".equals(activity.getReview())) {
			list = actDAO.selectReviewPass(activity);
		}else{
			list = actDAO.selectActList(activityDTO);	
		}
		for (Activity act : list) {
			act.setSecurePhotos(secPhDAO.selectByActivityId(act.getId()));
			act.setOrgPhotos(orgPhDAO.selectByActivityId(act.getId()));
		}
		return list;
	}
	
	@Override
	public List<Activity> getActList1(Activity activity) {
		// TODO Auto-generated method stub
		List<Activity> list = actDAO.selectActList(activityConversion.converToDTO(activity));	
		for (Activity act : list) {
			act.setSecurePhotos(secPhDAO.selectByActivityId(act.getId()));
			act.setOrgPhotos(orgPhDAO.selectByActivityId(act.getId()));
		}
		return list;
	}

	@Override
	public Activity getDetail(String id) {
		// TODO Auto-generated method stub
		Activity activity = actDAO.selectById(id);
		activity.setSecurePhotos(secPhDAO.selectByActivityId(id));
		activity.setOrgPhotos(orgPhDAO.selectByActivityId(id));
		return activity;
	}

	@Override
	public String getActivityId() {
		// TODO Auto-generated method stub
		return actDAO.selectId();
	}

	@Override
	public List<Activity> getHistoryList(Activity activity) {
		// TODO Auto-generated method stub
		List<Activity> list = actDAO.selectHistoryList(activity);
		for (Activity act : list) {
			act.setSecurePhotos(secPhDAO.selectByActivityId(act.getId()));
			act.setOrgPhotos(orgPhDAO.selectByActivityId(act.getId()));
		}
		return list;
	}
}
