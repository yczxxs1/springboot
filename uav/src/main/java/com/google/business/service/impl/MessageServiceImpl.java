package com.google.business.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.MessageDAO;
import com.google.business.model.MessageEntity;
import com.google.business.service.MessageService;
import com.google.business.util.jpush.Extra;
import com.google.business.util.jpush.Push;
import com.google.business.vo.MessageVO;
import com.google.common.exception.ServiceException;



@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO messageDAO;


	@Override
	public List<MessageEntity> getMessages(MessageEntity message) {
		// TODO Auto-generated method stub
			//String meType = message.getMessagetype();		
			List<MessageEntity> list = messageDAO.selectMessageList(message);
			return list;
	}

	@Override
	public MessageEntity getMessageDetail(MessageEntity message) {
		// TODO Auto-generated method stub
		MessageEntity me = messageDAO.selectMessageDetail(message);
		if (me==null) {
			throw new ServiceException("不存在！");
		}
		return me;
	}

	@Override
	public void delMessage(String id) {
		// TODO Auto-generated method stub
		 messageDAO.deleteMessage(id);
	
	}

	@Override
	public void push(String userId, String content) {
		// TODO Auto-generated method stub
		MessageEntity me=new MessageEntity("管制消息", content, "2", new Date(), "2",userId);
		messageDAO.insertMessage(me);
		//推送
	   Push.testSendPushByAlias(content, userId, new Extra().setMessageId(me.getId()));	
	}

	@Override
	public void pushBroadcast(String title, String content) {
		// TODO Auto-generated method stub
		MessageEntity me=new MessageEntity(title,content,"1",new Date(),"1","suibaitiande");
		messageDAO.insertMessage(me);
		Push.testSendPush(content);
		
	}

	@Override
	public List<MessageEntity> getBroadcastList(MessageVO messageVO) {
		// TODO Auto-generated method stub
		return messageDAO.selectListByTime(messageVO);
	}




}
