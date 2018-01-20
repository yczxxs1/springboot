package com.netflix.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.netflix.business.condition.QueryCondition;
import com.netflix.business.domain.Reply;
import com.netflix.business.dto.ReplyDTO;

@Mapper
public interface ReplyMapper {
    int deleteByPrimaryKey(String replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(String replyId);
    
    List<ReplyDTO> selectList(QueryCondition qc);
    
    List<ReplyDTO> selectListByCommentId(String replyCommentId);
    
    int selectCount(QueryCondition qc);
    
    int selectCountByCommentId(String replyCommentId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}