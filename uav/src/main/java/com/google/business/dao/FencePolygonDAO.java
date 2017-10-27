package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.FenceInfo;
import com.google.business.model.FencePolygon;


@Mapper
public interface FencePolygonDAO{
    
	int insertFencePolygon(FencePolygon fencePolygon);
   
	int updateFencePolygon(FencePolygon fencePolygon);
    
	List<FenceInfo> selectFencePolygon(FencePolygon fencePolygon);
    
    //FenceInfo selectFencePolygon(FencePolygon fencePolygon);
    
    int deleteFencePolygon(FencePolygon fencePolygon);
}
