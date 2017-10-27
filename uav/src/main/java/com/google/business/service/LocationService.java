package com.google.business.service;

import java.util.List;

import com.google.business.dto.LocationDTO;
import com.google.business.model.LocationInfoEntity;

public interface LocationService {
	
	public List<LocationInfoEntity> getLocationInfoForTheDay(LocationDTO locationDTO);
	public List<LocationInfoEntity> getList(LocationInfoEntity locationEntity);


	public List<LocationInfoEntity> getLocationForTime(LocationDTO locationDTO);
}
