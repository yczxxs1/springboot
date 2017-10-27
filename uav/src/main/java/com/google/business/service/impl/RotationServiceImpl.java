package com.google.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.RotationDAO;
import com.google.business.model.RotationEntity;
import com.google.business.service.RotationService;
import com.google.common.exception.ServiceException;
@Service 
public class RotationServiceImpl implements RotationService {
	
	@Autowired
	private RotationDAO rotationDao;
	@Override
	public List<RotationEntity> getOne(RotationEntity rotation) {
		List<RotationEntity> rotation1=rotationDao.selectOne(rotation);
		if(rotation1==null){
			throw new  ServiceException("不正确！");
		}
		return rotation1;
	}

}
