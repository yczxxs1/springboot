package com.google.business.service;

import java.util.List;

import com.google.business.model.FactoryEntity;
import com.google.business.model.UavModelEntity;

public interface UavModelService {
	public List<UavModelEntity> getUavModel(UavModelEntity uavModelEntity);
	
	public List<FactoryEntity> getFactoryMsg(FactoryEntity factoryEntity);
}
