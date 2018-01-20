package com.kaituo.communitypolicing.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kaituo.communitypolicing.business.domain.Bungalow;

@Mapper
public interface BungalowMapper {
	
	Bungalow selectBungalowById(String buildingId);
	
    int insert(Bungalow record);

    int insertSelective(Bungalow record);
}