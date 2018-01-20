package com.kaituo.communitypolicing.business.repository;

import org.apache.ibatis.annotations.Mapper;

import com.kaituo.communitypolicing.business.dao.BuildingMapper;
import com.kaituo.communitypolicing.business.dao.BungalowMapper;
import com.kaituo.communitypolicing.business.dao.HouseMapper;
import com.kaituo.communitypolicing.business.dao.TallBuildingMapper;

@Mapper
public interface BuildingRepository extends BuildingMapper,TallBuildingMapper,BungalowMapper,HouseMapper{

}
