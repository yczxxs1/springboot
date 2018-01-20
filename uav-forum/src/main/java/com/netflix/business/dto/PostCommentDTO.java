package com.netflix.business.dto;

import java.util.Date;
import java.util.List;

public class PostCommentDTO {

	private String commentId;

	private String commentContent;

	private String commentUserId;
	// 聚合之间的引用
	private String commentPostId;

	private Date commentCreateTime;

	private String commentUserName;

	private String commentUserAvatar;

	private Date currentTime;

	private int commentLikeCount;

	private boolean commentLikeStatus;
	

	private List<ReplyDTO> replys;



	public PostCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
		currentTime=new Date();
		
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getCommentPostId() {
		return commentPostId;
	}

	public void setCommentPostId(String commentPostId) {
		this.commentPostId = commentPostId;
	}

	public Date getCommentCreateTime() {
		return commentCreateTime;
	}

	public void setCommentCreateTime(Date commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}

	public String getCommentUserName() {
		return commentUserName;
	}

	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}

	public String getCommentUserAvatar() {
		return commentUserAvatar;
	}

	public void setCommentUserAvatar(String commentUserAvatar) {
		this.commentUserAvatar = commentUserAvatar;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public int getCommentLikeCount() {
		return commentLikeCount;
	}

	public void setCommentLikeCount(int commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
	}

	public boolean isCommentLikeStatus() {
		return commentLikeStatus;
	}

	public void setCommentLikeStatus(boolean commentLikeStatus) {
		this.commentLikeStatus = commentLikeStatus;
	}

	public List<ReplyDTO> getReplys() {
		return replys;
	}

	public void setReplys(List<ReplyDTO> replys) {
		this.replys = replys;
	}

}
