package com.netflix.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.netflix.business.domain.PostImg;

@Mapper
public interface PostImgMapper {
    int deleteByPrimaryKey(String postImgId);

    int insert(PostImg record);

    int insertSelective(PostImg record);

    PostImg selectByPrimaryKey(String postImgId);
    
    Integer selectCountByPostId(String postId);
    
    List<PostImg> selectListByPostId(String postId);

    int updateByPrimaryKeySelective(PostImg record);

    int updateByPrimaryKey(PostImg record);
}