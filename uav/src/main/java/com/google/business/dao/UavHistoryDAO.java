package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.UavHistoryEntity;

@Mapper
public interface UavHistoryDAO {
    int deleteByPrimaryKey(Long id);

    int insert(UavHistoryEntity record);

    int insertSelective(UavHistoryEntity record);

    UavHistoryEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UavHistoryEntity record);

    int updateByPrimaryKey(UavHistoryEntity record);
    
    List<UavHistoryEntity> selectBySnNumber(UavHistoryEntity uavHistoryEntity);
}