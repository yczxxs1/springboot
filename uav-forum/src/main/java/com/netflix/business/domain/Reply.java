package com.netflix.business.domain;

import java.util.Date;

//聚合根
public class Reply {
	private String replyId;

	private String replyContent;

	private String replyUserId;
	// 聚合之间的引用
	private String replyCommentId;

	private Date replyCreateTime;
	
	

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
		replyCreateTime=new Date();
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId == null ? null : replyId.trim();
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent == null ? null : replyContent.trim();
	}

	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(String replyCommentId) {
		this.replyCommentId = replyCommentId == null ? null : replyCommentId.trim();
	}

	public Date getReplyCreateTime() {
		return replyCreateTime;
	}

	public void setReplyCreateTime(Date replyCreateTime) {
		this.replyCreateTime = replyCreateTime;
	}
}