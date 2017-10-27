package com.google.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.Companys;

@Mapper
public interface CompanysDAO {
    int deleteByPrimaryKey(String id);

    Companys selectOne(Companys record);
    
    Companys selectByUserId(String userId);

    int insertSelective(Companys record);

    Companys selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Companys record);

   
}