package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.Aircraft;
@Mapper
public interface AircraftDAO {
    int deleteByPrimaryKey(String id);

    int insert(Aircraft record);

    int insertSelective(Aircraft record);

    Aircraft selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Aircraft record);

    int updateByPrimaryKey(Aircraft record);
    
    List<Aircraft> selectCategoryList(Aircraft record);
}