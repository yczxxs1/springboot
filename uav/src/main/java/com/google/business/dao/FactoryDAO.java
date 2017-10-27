package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.google.business.model.FactoryEntity;

@Mapper
public interface FactoryDAO {

    int insertSelective(FactoryEntity factoryEntity);
    
    int deleteByPrimaryKey(FactoryEntity factoryEntity);
    
    int updateByPrimaryKeySelective(FactoryEntity factoryEntity);
    
    List<FactoryEntity> selectFactoryList(FactoryEntity factoryEntity);
    
    FactoryEntity selectFactoryOne(FactoryEntity factoryEntity);
}