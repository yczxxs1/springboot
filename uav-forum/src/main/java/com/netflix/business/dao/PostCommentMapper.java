package com.netflix.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.netflix.business.condition.QueryCondition;
import com.netflix.business.domain.PostComment;
import com.netflix.business.dto.PostCommentDTO;

@Mapper
public interface PostCommentMapper {
    int deleteByPrimaryKey(String commentId);

    int insert(PostComment record);

    int insertSelective(PostComment record);

    PostCommentDTO selectByPrimaryKey(String commentId);
    
    int selectCountByPostId(String postId);
    
    int selectCountbyCondition(QueryCondition qc);
    
    List<PostCommentDTO> selectList(QueryCondition qc);
    
    List<PostCommentDTO> selectListByPostId(String postId);

    int updateByPrimaryKeySelective(PostComment record);

    int updateByPrimaryKey(PostComment record);
}