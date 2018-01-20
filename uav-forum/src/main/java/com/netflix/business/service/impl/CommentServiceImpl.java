package com.netflix.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.netflix.business.condition.QueryCondition;
import com.netflix.business.dao.PostCommentMapper;
import com.netflix.business.dao.VisitTimeMapper;
import com.netflix.business.domain.PostComment;
import com.netflix.business.domain.VisitTime;
import com.netflix.business.dto.PostCommentDTO;
import com.netflix.business.exception.CommentNotFoundException;
import com.netflix.business.service.CommentService;
import com.netflix.business.service.LikeUpService;
import com.netflix.business.service.ReplyService;
@Service
public class CommentServiceImpl implements CommentService {
	

	@Autowired
	private PostCommentMapper commentMapper;
	@Autowired
	private VisitTimeMapper visitTimeMapper;
	@Autowired
	private LikeUpService likeUpService;
	@Autowired
	private ReplyService replyService;
	
	private static final Integer commentListReplyPage=1;
	
	private static final Integer commentListReplySize=2;
	

	@Override
	public void comment(PostComment comment) throws Exception {
		// TODO Auto-generated method stub
		
		commentMapper.insertSelective(comment);

	}

	@Override
	public int countLatestComment(String loginUserId,String commentPostId) throws Exception {
		// TODO Auto-generated method stub
		if(loginUserId==null) throw new IllegalArgumentException();
		QueryCondition qc=new QueryCondition();
		qc.setPostUserId(loginUserId);
		VisitTime visitTime=visitTimeMapper.selectByVisitTimeUserId(loginUserId);
		if(visitTime==null)return 0;
		qc.setMyPostListVisitTime(visitTime.getVisitTimeMyPost());
		qc.setCommentPostId(commentPostId);
		return commentMapper.selectCountbyCondition(qc);
	}

	@Override
	public List<PostCommentDTO> listComment(String commentPostId) throws Exception {
		// TODO Auto-generated method stub
		return commentMapper.selectListByPostId(commentPostId);
	}

	@Override
	public PostCommentDTO getComment(String commentId) throws Exception {
		// TODO Auto-generated method stub
		PostCommentDTO postCommentDTO=commentMapper.selectByPrimaryKey(commentId);
		if(postCommentDTO==null) throw new CommentNotFoundException(commentId);
		return postCommentDTO;
	}

	@Override
	public List<PostCommentDTO> listComment(String commentPostId, String loginUserId) throws Exception {
		// TODO Auto-generated method stub
		List<PostCommentDTO> list=listComment(commentPostId);
		for(PostCommentDTO postCommentDTO:list) {
			String commentId=postCommentDTO.getCommentId();
			//评论点赞状态
			postCommentDTO.setCommentLikeStatus(likeUpService.getLikeUpStatus(commentId, loginUserId));
			//回复
			PageHelper.startPage(commentListReplyPage, commentListReplySize);
	       postCommentDTO.setReplys(replyService.listReply(commentId));
		
		}
		
		return list;
	}

}
