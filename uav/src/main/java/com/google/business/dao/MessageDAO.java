package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.MessageEntity;
import com.google.business.vo.MessageVO;


@Mapper
public interface MessageDAO {
	 
    int insertMessage(MessageEntity messageEntity);
    
    int updateMessage(MessageEntity messageEntity);
    
    List<MessageEntity> selectMessageList(MessageEntity messageEntity);
    
    List<MessageEntity> selectListByTime(MessageVO messageVO);
    
    /**
     * selectOne => select_list
     * @param messageEntity
     * @return
     */
    MessageEntity selectMessageDetail(MessageEntity messageEntity);
    
    int deleteMessage(String id);
    
}