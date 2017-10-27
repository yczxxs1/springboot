package com.google.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.Police;

@Mapper
public interface PoliceDAO {
    int deleteByPrimaryKey(String id);

    int insert(Police record);

    int insertSelective(Police record);

    Police selectByPrimaryKey(String id);
    
    Police selectOne(Police record);
    
    Police selectByUserId(String userId);

    int updateByPrimaryKeySelective(Police record);

    int updateByPrimaryKey(Police record);
}