package com.netflix.business.service;

import java.util.List;

import com.netflix.business.domain.Reply;
import com.netflix.business.dto.ReplyDTO;

public interface ReplyService {

	/**
	 * 发布回复
	 * @param reply
	 * @throws Exception
	 */
	void reply(Reply reply) throws Exception;
	
	/**
	 * 查询回复列表
	 * @param replyCommentId
	 * @return
	 * @throws Exception
	 */
	List<ReplyDTO> listReply(String replyCommentId) throws Exception;
	
	/**
	 * 查询回复数
	 * @param replyCommentId
	 * @return
	 * @throws Exception
	 */
	int countReply(String replyCommentId) throws Exception;
}
