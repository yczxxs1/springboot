package com.google.business.dao;

import com.google.business.model.SaleinfoPhotoEntity;

public interface SaleinfoPhotoEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(SaleinfoPhotoEntity record);

    int insertSelective(SaleinfoPhotoEntity record);

    SaleinfoPhotoEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SaleinfoPhotoEntity record);

    int updateByPrimaryKey(SaleinfoPhotoEntity record);
}