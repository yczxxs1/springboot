package com.google.business.service;

import java.util.List;

import com.google.business.model.Aircraft;

public interface AircraftService {
	List<Aircraft> queryUavBelongTypeList(Aircraft aircraft);
}
