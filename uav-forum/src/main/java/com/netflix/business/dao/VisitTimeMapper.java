package com.netflix.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.netflix.business.domain.VisitTime;

@Mapper
public interface VisitTimeMapper {
    int deleteByPrimaryKey(String visitTimeId);

    int insert(VisitTime record);

    int insertSelective(VisitTime record);

    VisitTime selectByPrimaryKey(String visitTimeId);
    
    VisitTime selectByVisitTimeUserId(String visitTimeUserId);

    int updateByPrimaryKeySelective(VisitTime record);

    int updateByPrimaryKey(VisitTime record);
}