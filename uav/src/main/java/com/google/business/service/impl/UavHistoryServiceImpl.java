package com.google.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.business.dao.UavHistoryDAO;
import com.google.business.model.UavHistoryEntity;
import com.google.business.service.UavHistoryService;


@Service
public class UavHistoryServiceImpl implements UavHistoryService{

	@Autowired
	private UavHistoryDAO uavHistoryDAO;
	
	@Override
	@Transactional
	public List<UavHistoryEntity> querySaleDetail(UavHistoryEntity uavHistoryEntity){
		List<UavHistoryEntity> uavHistory = uavHistoryDAO.selectBySnNumber(uavHistoryEntity);
		return uavHistory;
	}
		
}
