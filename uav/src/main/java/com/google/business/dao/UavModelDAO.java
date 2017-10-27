package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.google.business.model.UavModelEntity;

@Mapper
public interface UavModelDAO {
    int insertSelective(UavModelEntity uavModelEntity);
    
    int deleteByPrimaryKey(UavModelEntity uavModelEntity);
    
    int updateByPrimaryKeySelective(UavModelEntity uavModelEntity);
    
    List<UavModelEntity> selectUavModelList(UavModelEntity uavModelEntity);
    
    UavModelEntity selectUavModelOne(UavModelEntity uavModelEntity);
}