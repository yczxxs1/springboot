package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.google.business.model.DictEntity;

@Mapper
public interface DictDAO {

    int insertSelective(DictEntity dictEntity);
    
    int deleteByPrimaryKey(DictEntity dictEntity);
    
    int updateByPrimaryKeySelective(DictEntity dictEntity);

    List<DictEntity> selectDictList(DictEntity dictEntity);
    
    List<DictEntity> selectDictList_Type(DictEntity dictEntity);
    
    List<String> selectDictList_Label(DictEntity dictEntity);
    
    DictEntity selectDictOne(DictEntity dictEntity);
    
}