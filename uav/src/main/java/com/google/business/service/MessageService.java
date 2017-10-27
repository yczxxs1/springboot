package com.google.business.service;

import java.util.List;

import com.google.business.model.MessageEntity;
import com.google.business.vo.MessageVO;

public interface MessageService {
	public List<MessageEntity> getMessages(MessageEntity message);
	public MessageEntity getMessageDetail(MessageEntity message);
	public void delMessage(String id);
	public void push(String userId,String content);
	public void pushBroadcast(String title,String content);
    public List<MessageEntity> getBroadcastList(MessageVO messageVO);
	
}
