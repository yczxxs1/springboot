package com.google.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.AircraftDAO;
import com.google.business.model.Aircraft;
import com.google.business.service.AircraftService;

@Service
public class AircraftServiceImpl implements AircraftService {

	@Autowired
	private AircraftDAO aircraftDAO;
	@Override
	public List<Aircraft> queryUavBelongTypeList(Aircraft aircraft) {
		List<Aircraft> aricraftList=  aircraftDAO.selectCategoryList(aircraft);
		return aricraftList;
	}

}
