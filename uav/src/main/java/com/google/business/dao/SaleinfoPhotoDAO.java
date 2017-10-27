package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.SaleinfoPhotoEntity;
@Mapper
public interface SaleinfoPhotoDAO {
    int deleteByPrimaryKey(String id);

    int insert(SaleinfoPhotoEntity record);

    int insertSelective(SaleinfoPhotoEntity record);

    SaleinfoPhotoEntity selectByPrimaryKey(String id);
    List<SaleinfoPhotoEntity> selectDetail(SaleinfoPhotoEntity saleinfoPhotoEntity);
    int updateByPrimaryKeySelective(SaleinfoPhotoEntity record);

    int updateByPrimaryKey(SaleinfoPhotoEntity record);
    
    SaleinfoPhotoEntity selectSaleinfoPhotoFirst(SaleinfoPhotoEntity record);
}