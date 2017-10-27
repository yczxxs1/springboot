package com.google.business.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.business.dao.ActUavDAO;
import com.google.business.dao.InsurancePhotoDAO;
import com.google.business.dao.UavDAO;
import com.google.business.dao.UavPhotoDAO;
import com.google.business.dao.UserDAO;
import com.google.business.model.ActUav;
import com.google.business.model.InsurancePhoto;
import com.google.business.model.UavEntity;
import com.google.business.model.UavPhotoEntity;
import com.google.business.model.User;
import com.google.business.service.ActUavService;
import com.google.business.util.fastDFS.FastDFSFileUtils;
import com.google.common.exception.ServiceException;

@Service
public class ActUavServiceImpl implements ActUavService {
	@Autowired
	private ActUavDAO actUavDAO;
	@Autowired
	private InsurancePhotoDAO insPhDAO;
	@Autowired
	private UavDAO uavDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UavPhotoDAO upDAO;

	@Override // 新增活动无人机
	@Transactional
	public void createActUav(ActUav actUav, List<File> files) throws Exception {
		// TODO Auto-generated method stub
     try {
    	 if(actUav.getActId()==null){
    		 throw new ServiceException("没有活动Id");
    	 }
    	 UavEntity uav = new UavEntity();
 		uav.setSnNumber(actUav.getSnNumber());
 		UavEntity uav0 = uavDAO.selectUavBySnNumber(uav);

 		// 校验无人机
 		if (uav0 == null) {
 			throw new ServiceException("此无人机还没有被登记！");
 		}
 		if (!"2".equals(uav0.getReview()) && "1".equals(uav0.getStatus())) {
 			throw new ServiceException("无人机审核未通过！");
 		}
 	    //校验活动无人机是否重复
 		ActUav actuav=new ActUav();
 		actuav.setSnNumber(actUav.getSnNumber());
 		actuav.setActId(actUav.getActId());
 		ActUav actuav0=actUavDAO.selectOne(actuav);
 		if(actuav0!=null){
 			throw new ServiceException("该活动下已有此无人机！");
 		}
 		// 校验驾驶员
 		User user = new User();
 		user.setCertNumber(actUav.getUserNumber());
 		user.setUserMobile(actUav.getUserPhone());
 		User user0=userDAO.selectOne(user);
 		if ( user0== null) {
 			throw new ServiceException("该驾驶员不存在！");
 		}
 		String userStatus=user0.getUserStatus();
 		if("0".equals(userStatus)){
 			throw new ServiceException("该驾驶员信息未完善！");
 		}
 		// 新增
 		actUavDAO.insertSelective(actUav);
 		if (files != null) {
 			for (File file : files) {
 				String photoUrl = FastDFSFileUtils.uploadFileToDfs(file);
 				insPhDAO.insertSelective(new InsurancePhoto(actUav.getId(), photoUrl, new Date()));
 			}
 		}
	} finally {
		// TODO: handle finally clause
		for(File file:files){
			file.delete();
		}
	}
		
	}

	// 删除活动无人机 参数：id（活动无人机id）
	@Override
	public void delActUav(String id) {
		// TODO Auto-generated method stub
			actUavDAO.deleteByPrimaryKey(id);
			insPhDAO.deleteByPrimaryKey(id);
	}

	@Override
	public void updateActUav(ActUav actUav) {
		// TODO Auto-generated method stub
	}

	@Override // 获取无人鸡列表
	public List<ActUav> getActUavList(ActUav actUav) {
		if (actUav.getActId() == null) {
			throw new ServiceException("非法的活动！");
		} else {
			List<ActUav> list = actUavDAO.selectActUavList(actUav);
			for (ActUav au : list) {
				UavEntity ue = new UavEntity();
				ue.setSnNumber(au.getSnNumber());
				UavPhotoEntity upe = upDAO.selectUavPhotoFirst(uavDAO.selectUavOne(ue).getId());
				if (upe != null) {
					au.setPhUrl(upe.getPhotoUrl());
					au.setInsPhotos(insPhDAO.selectByActUavId(au.getId()));
				}
			}
			return list;
		}
	}

	// 查看活动无人机详情 （参数：无人机id）
	@Override
	public ActUav getDetail(ActUav actUav) {
		// TODO Auto-generated method stub
		ActUav au = actUavDAO.selectOne(actUav);
		if (au == null) {
			throw new ServiceException("参数错误！");
		}
		au.setInsPhotos(insPhDAO.selectByActUavId(au.getId()));
		return au;
	}

	@Override
	public void review(ActUav actUav) {
		// TODO Auto-generated method stub
		if ("2".equals(actUavDAO.selectOne(actUav).getReview())) {
			throw new ServiceException("该无人机已审核！");
		} else {
			int au = actUavDAO.updateReview(actUav);
			if (au == 0) {
				throw new ServiceException("参数错误！");
			}
		}
	}

	@Override
	public List<ActUav> getAUList(ActUav actUav) {
		// TODO Auto-generated method stub
		if (actUav.getActId() == null) {
			throw new ServiceException("非法的活动！");
		} else {
			List<ActUav> list = actUavDAO.selectRP(actUav);
			return list;
		}
	}
}
