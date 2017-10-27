package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.InsurancePhoto;
@Mapper
public interface InsurancePhotoDAO {
    int deleteByPrimaryKey(String id);

    int insert(InsurancePhoto record);

    int insertSelective(InsurancePhoto record);

    InsurancePhoto selectByPrimaryKey(String id);
    
    List<InsurancePhoto> selectByActUavId(String actUavId);

    int updateByPrimaryKeySelective(InsurancePhoto record);

    int updateByPrimaryKey(InsurancePhoto record);
}