package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.CompanyPhoto;

@Mapper
public interface CompanyPhotoDAO {
    int deleteByPrimaryKey(String id);
    
    int deleteByCompanyId(String userId);

    int insert(CompanyPhoto record);

    int insertSelective(CompanyPhoto record);

    CompanyPhoto selectByPrimaryKey(String id);
    
    List<CompanyPhoto> selectListByCompanyId(String companyId);

    int updateByPrimaryKeySelective(CompanyPhoto record);

    int updateByPrimaryKey(CompanyPhoto record);
}