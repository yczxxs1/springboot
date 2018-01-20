package com.netflix.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.netflix.business.domain.PostVisit;

@Mapper
public interface PostVisitMapper {
    int deleteByPrimaryKey(String postVisitId);

    int insert(PostVisit record);
    
    int selectCountByPostId(String postId);

    int insertSelective(PostVisit record);

    PostVisit selectByPrimaryKey(String postVisitId);

    int updateByPrimaryKeySelective(PostVisit record);

    int updateByPrimaryKey(PostVisit record);
}