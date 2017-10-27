package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.FenceInfo2;
import com.google.business.model.FencePoint;

@Mapper
public interface FencePointDAO {


	List<FenceInfo2> selectPOI(FencePoint fencePoint);
    

	List<FenceInfo2> selectFencePoint(FencePoint fencePoint);
    
    
    
   
}
