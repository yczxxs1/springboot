package com.netflix.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.netflix.business.domain.LikeUp;
@Mapper
public interface LikeUpMapper {
    int deleteByPrimaryKey(String likeId);

    int insert(LikeUp record);

    int insertSelective(LikeUp record);

    LikeUp selectByPrimaryKey(String likeId);
    
    LikeUp select(LikeUp likeUp);
    
    int selectCountByObjectId(String ObjectId);
    
    int selectCount(LikeUp record);

    int updateByPrimaryKeySelective(LikeUp record);

    int updateByPrimaryKey(LikeUp record);
}