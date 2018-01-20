package com.netflix.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.business.dao.ReplyMapper;
import com.netflix.business.domain.Reply;
import com.netflix.business.dto.ReplyDTO;
import com.netflix.business.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public void reply(Reply reply) throws Exception {
		// TODO Auto-generated method stub
		
		replyMapper.insertSelective(reply);
		
	}

	@Override
	public List<ReplyDTO> listReply(String replyCommentId) throws Exception {
		// TODO Auto-generated method stub
		return replyMapper.selectListByCommentId(replyCommentId);
	}

	@Override
	public int countReply(String replyCommentId) throws Exception {
		// TODO Auto-generated method stub

		return replyMapper.selectCountByCommentId(replyCommentId);
	}

}
