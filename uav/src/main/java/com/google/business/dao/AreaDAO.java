package com.google.business.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.google.business.model.Area;

@Mapper

public interface AreaDAO {
    int deleteByPrimaryKey(String areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(String areaId);
    
    List<Area> selectAll(Area areaFatherId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}