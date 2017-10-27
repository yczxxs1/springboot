package com.google.business.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.Province;

@Mapper
public interface ProvinceDAO {
    int deleteByPrimaryKey(String provinceId);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectAll();
    
    Province selectOne(Province record);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}