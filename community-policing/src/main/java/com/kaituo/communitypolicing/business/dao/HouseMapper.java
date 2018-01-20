package com.kaituo.communitypolicing.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kaituo.communitypolicing.business.domain.House;

@Mapper
public interface HouseMapper {
    int deleteByPrimaryKey(String houseId);

    int insert(House record);

    int insertSelective(House record);

    House selectByHouseId(String houseId);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKeyWithBLOBs(House record);

    int updateByPrimaryKey(House record);
}