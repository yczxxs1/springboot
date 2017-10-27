package com.google.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.LocationInfoDAO;
import com.google.business.dao.UserDAO;
import com.google.business.dto.LocationDTO;
import com.google.business.model.LocationInfoEntity;
import com.google.business.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	private LocationInfoDAO locationInfoDAO;
	@Autowired
	private UserDAO userDAO;
	

	@Override
	public List<LocationInfoEntity> getLocationInfoForTheDay(LocationDTO locationDTO) {
		// TODO Auto-generated method stub
		List<LocationInfoEntity> list=locationInfoDAO.selectLocationInfoForTheDay(locationDTO);
		for(LocationInfoEntity lie:list){
			lie.setUser(userDAO.selectByPrimaryKey(lie.getUserId()));
		}
		return list;
	}


	@Override
	public List<LocationInfoEntity> getList(LocationInfoEntity locationEntity) {
		// TODO Auto-generated method stub
		List<LocationInfoEntity> list=locationInfoDAO.selectLocationInfo(locationEntity);
		return list;
	}



	@Override
	public List<LocationInfoEntity> getLocationForTime(LocationDTO locationDTO) {
		// TODO Auto-generated method stub
		List<LocationInfoEntity> list=locationInfoDAO.selectLocationInfoForTime(locationDTO);
		for(LocationInfoEntity lie:list){
			lie.setUser(userDAO.selectByPrimaryKey(lie.getUserId()));
		}
		return list;
	}

}
