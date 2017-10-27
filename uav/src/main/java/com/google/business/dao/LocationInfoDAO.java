package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.dto.LocationDTO;
import com.google.business.model.LocationInfoEntity;

@Mapper
public interface LocationInfoDAO {
	
    int insertLocationInfo(LocationInfoEntity locationInfoEntity);
    
    int updateLocationInfo(LocationInfoEntity locationInfoEntity);
    
    List<LocationInfoEntity> selectLocationInfo(LocationInfoEntity locationInfoEntity);
    
    List<LocationInfoEntity> selectLocationInfoForTwoHour(LocationInfoEntity locationInfoEntity);
   
    List<LocationInfoEntity> selectLocationInfoForTheDay(LocationDTO locationDTO);
    
    List<LocationInfoEntity> selectLocationInfoForTime(LocationDTO locationDTO);
	
  
}