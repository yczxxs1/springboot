package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.FenceInfo;


@Mapper
public interface FenceInfoDAO{

    int insertFenceInfo(FenceInfo fenceInfo);
    
    int updateFenceInfo(FenceInfo fenceInfo);
    
    List<FenceInfo> selectFenceInfo(FenceInfo fenceInfo);
    
    //查询所有实体
    List<FenceInfo> selectFenceInfo_monited_person(FenceInfo fenceInfo);
    
    //FenceInfo selectFenceInfo(FenceInfo fenceInfo);
    
    int deleteFenceInfo(FenceInfo fenceInfo);
}
