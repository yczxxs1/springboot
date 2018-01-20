package com.netflix.business.service;

import java.util.List;

import com.netflix.business.domain.PostComment;
import com.netflix.business.dto.PostCommentDTO;

public interface CommentService {
	/**
	 * 发布评论
	 * @param comment
	 * @throws Exception
	 */
	void comment(PostComment comment) throws Exception;

	/**
	 * @param loginUserId 登录用户Id，不能为空
	 * @param commentPostId 某个帖子下新评论数
	 * @return 帖子的最新评论数
	 * @throws Exception
	 */
	int countLatestComment(String loginUserId,String commentPostId) throws Exception;

	/**
	 * 评论列表
	 * @return
	 * @throws Exception
	 */
	List<PostCommentDTO> listComment(String commentPostId) throws Exception;
	
	/**
	 * 用户查看评论列表(包含点赞状态和0-2条回复)
	 * @param commentPostId
	 * @param loginUserId
	 * @return
	 * @throws Exception
	 */
	List<PostCommentDTO> listComment(String commentPostId,String loginUserId) throws Exception;

	/**
	 * 评论详情
	 * @param commentId
	 * @return
	 * @throws Exception
	 */
	PostCommentDTO getComment(String commentId) throws Exception;
	
	

}
