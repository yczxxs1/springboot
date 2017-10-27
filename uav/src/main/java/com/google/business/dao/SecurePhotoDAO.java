package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.SecurePhoto;
@Mapper
public interface SecurePhotoDAO {
    int deleteByPrimaryKey(String id);

    int insert(SecurePhoto record);

    int insertSelective(SecurePhoto record);

    SecurePhoto selectByPrimaryKey(String id);
    
    List<SecurePhoto> selectByActivityId(String activityId);

    int updateByPrimaryKeySelective(SecurePhoto record);

    int updateByPrimaryKey(SecurePhoto record);
}