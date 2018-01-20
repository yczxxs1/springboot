package com.netflix.business.dto;

import java.util.Date;

public class ReplyDTO {

	private String replyId;

	private String replyContent;

	private String replyUserId;

	private String replyCommentId;

	private Date replyCreateTime;

	private String replyUserName;

	private String replyUserAvatar;

	private Date currentTime;
	
	

	public ReplyDTO() {
		super();
		// TODO Auto-generated constructor stub
		currentTime=new Date();
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(String replyCommentId) {
		this.replyCommentId = replyCommentId;
	}

	public Date getReplyCreateTime() {
		return replyCreateTime;
	}

	public void setReplyCreateTime(Date replyCreateTime) {
		this.replyCreateTime = replyCreateTime;
	}

	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public String getReplyUserAvatar() {
		return replyUserAvatar;
	}

	public void setReplyUserAvatar(String replyUserAvatar) {
		this.replyUserAvatar = replyUserAvatar;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

}
