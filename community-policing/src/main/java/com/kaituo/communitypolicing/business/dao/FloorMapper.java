package com.kaituo.communitypolicing.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kaituo.communitypolicing.business.model.Floor;

@Mapper
public interface FloorMapper {
    int deleteByPrimaryKey(String floorId);

    int insert(Floor record);

    int insertSelective(Floor record);

    Floor selectByPrimaryKey(String floorId);

    int updateByPrimaryKeySelective(Floor record);

    int updateByPrimaryKey(Floor record);
}