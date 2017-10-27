package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.google.business.model.UavPhotoEntity;

@Mapper
public interface UavPhotoDAO{

    int insertSelective(UavPhotoEntity uavPhotoEntity);
    
    int deleteByUavId(UavPhotoEntity uavId);
    
    int deleteByPrimaryKey(UavPhotoEntity uavPhotoEntity);
    
    int updateByPrimaryKeySelective(UavPhotoEntity uavPhotoEntity);
    
    List<UavPhotoEntity> selectUavPhotoList(UavPhotoEntity uavPhotoEntity);
    
    UavPhotoEntity selectUavPhotoOne(UavPhotoEntity uavPhotoEntity);
    
    UavPhotoEntity selectUavPhotoFirst(String uavId);
}