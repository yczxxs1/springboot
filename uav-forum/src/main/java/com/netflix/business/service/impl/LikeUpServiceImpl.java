package com.netflix.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.business.dao.LikeUpMapper;
import com.netflix.business.domain.LikeUp;
import com.netflix.business.service.LikeUpService;

@Service
public class LikeUpServiceImpl implements LikeUpService{
	
	@Autowired
	private LikeUpMapper likeUpMapper;

	@Override
	public boolean getLikeUpStatus(String objectId, String userId) {
		// TODO Auto-generated method stub
		return likeUpMapper.selectCount(new LikeUp(objectId, userId)) != 0;
	}

	@Override
	public Boolean likeOrCancelLike(String objectId,String userId) {
		// TODO Auto-generated method stub
		LikeUp likeUp=likeUpMapper.select(new LikeUp(objectId, userId));
		if(likeUp == null) {
			likeUpMapper.insertSelective(new LikeUp(objectId, userId));
			return true;
		}else {
			likeUpMapper.deleteByPrimaryKey(likeUp.getLikeId());
			return false;
		}
		
		
	}

}
