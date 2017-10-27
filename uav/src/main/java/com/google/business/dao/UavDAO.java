package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.google.business.model.UavEntity;

@Mapper
public interface UavDAO{
    int insertSelective(UavEntity uavEntity);
    
    int deleteByPrimaryKey(UavEntity uavEntity);
    
    int deleteByBelongId(UavEntity uavEntity);
    
    int updateByPrimaryKeySelective(UavEntity uavEntity);
   
    List<UavEntity> selectUavList(UavEntity uavEntity);
    
    List<UavEntity> selectUavListByArea(@Param("uav")UavEntity uavEntity,@Param("areaId")String[] areaId);
    
    int selectUavList_count(UavEntity uavEntity);
   
    UavEntity selectUavOne(UavEntity uavEntity);
    
    UavEntity selectUavOneDetail(UavEntity uavEntity);
    
    List<UavEntity> selectByFactoryId(UavEntity uavEntity);
    
    List<UavEntity> selectExceptWuXi(UavEntity uavEntity);
    
    UavEntity selectNameByUavStatus(UavEntity uavEntity);
    
    void deleteBySnNumber(UavEntity uavEntity);
    
    UavEntity selectUavBySnNumber(UavEntity uavEntity);
}