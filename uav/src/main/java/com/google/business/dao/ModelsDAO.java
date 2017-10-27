package com.google.business.dao;

import com.google.business.model.Models;

public interface ModelsDAO {
    int deleteByPrimaryKey(String modelId);

    int insert(Models record);

    int insertSelective(Models record);

    Models selectByPrimaryKey(String modelId);

    int updateByPrimaryKeySelective(Models record);

    int updateByPrimaryKey(Models record);
}