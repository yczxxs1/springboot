package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.FenceCircle;
import com.google.business.model.FenceInfo;



@Mapper
public interface FenceCircleDAO {

    int insertFenceCircle(FenceCircle fenceCircle);
    
	int update(FenceCircle fenceCircle);
    
	List<FenceInfo> selectFenceCircle(FenceCircle fenceCircle);
    
    //FenceInfo selectFenceCircle(FenceCircle fenceCircle);
    
    int deleteFenceCircle(FenceCircle fenceCircle);
}
