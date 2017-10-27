package com.google.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.Person;
@Mapper
public interface PersonDAO {
    int deleteByPrimaryKey(String id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectOne(Person record);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}