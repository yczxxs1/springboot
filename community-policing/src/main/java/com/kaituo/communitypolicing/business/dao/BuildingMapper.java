package com.kaituo.communitypolicing.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kaituo.communitypolicing.business.domain.Building;
import com.kaituo.communitypolicing.business.domain.Coordinate;
import com.kaituo.communitypolicing.business.vo.BuildingListVo;

@Mapper
public interface BuildingMapper {
	
	List<BuildingListVo> selectListByCoordinate(Coordinate coordinate);
	
	
	
	
	
	
	
	
	
    int deleteByPrimaryKey(String buildingId);

    int insert(Building record);

    int insertSelective(Building record);

    Building selectByPrimaryKey(String buildingId);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKeyWithBLOBs(Building record);

    int updateByPrimaryKey(Building record);
}