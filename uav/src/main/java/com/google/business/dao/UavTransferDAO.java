package com.google.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.UavTransferEntity;
@Mapper
public interface UavTransferDAO {
    int deleteByPrimaryKey(String id);

    int insert(UavTransferEntity record);

    int insertSelective(UavTransferEntity record);

    UavTransferEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UavTransferEntity record);

    int updateByPrimaryKey(UavTransferEntity record);
    
}