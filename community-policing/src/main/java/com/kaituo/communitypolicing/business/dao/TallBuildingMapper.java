package com.kaituo.communitypolicing.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kaituo.communitypolicing.business.domain.Floor;
import com.kaituo.communitypolicing.business.domain.TallBuilding;


@Mapper
public interface TallBuildingMapper {
	
	TallBuilding selectTallBuildingById(String buildingId);
	
	List<Floor> selectFloorByUnitId(String unitId);
	
    
}