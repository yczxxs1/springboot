package com.netflix.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.netflix.business.condition.QueryCondition;
import com.netflix.business.domain.Post;
import com.netflix.business.dto.PostDTO;

@Mapper
public interface PostMapper {
    int deleteByPrimaryKey(String postId);

    int insert(Post record);

    int insertSelective(Post record);

    PostDTO selectByPrimaryKey(String postId);
    
    List<PostDTO> selectList(QueryCondition condition);
    
    int selectCountByCondition(QueryCondition condition);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}