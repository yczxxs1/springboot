package com.google.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.FactoryDAO;
import com.google.business.dao.UavModelDAO;
import com.google.business.model.FactoryEntity;
import com.google.business.model.UavModelEntity;
import com.google.business.service.UavModelService;

@Service
public class UavModelServiceImpl implements UavModelService{
	@Autowired
	private UavModelDAO uavModelDao;
	@Autowired
	private FactoryDAO factoryDAO;
	
	@Override
	public List<UavModelEntity> getUavModel(UavModelEntity uavModelEntity) {
		return uavModelDao.selectUavModelList(uavModelEntity);
	}
	
	@Override
	public List<FactoryEntity> getFactoryMsg(FactoryEntity factoryEntity) {
		return factoryDAO.selectFactoryList(factoryEntity);
	}
}
