package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.Emp;

@Mapper
public interface EmpDAO {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectList(Emp emp);
    
    Emp selectOne(Emp emp);

    int updateByPrimaryKeySelective(Emp emp);

   
}