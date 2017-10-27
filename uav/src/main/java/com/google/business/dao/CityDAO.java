package com.google.business.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.City;
@Mapper
public interface CityDAO {
    int deleteByPrimaryKey(String cityId);

    int insert(City record);

    int insertSelective(City record);

    City selectOne(City city);
    
    List<City> selectAll(City cityFatherId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}