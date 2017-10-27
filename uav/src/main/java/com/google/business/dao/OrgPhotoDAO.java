package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.OrgPhoto;
@Mapper
public interface OrgPhotoDAO {
    int deleteByPrimaryKey(String id);

    int insert(OrgPhoto record);

    int insertSelective(OrgPhoto record);

    OrgPhoto selectByPrimaryKey(String id);
    
    List<OrgPhoto> selectByActivityId(String ActivityId);

    int updateByPrimaryKeySelective(OrgPhoto record);

    int updateByPrimaryKey(OrgPhoto record);
}