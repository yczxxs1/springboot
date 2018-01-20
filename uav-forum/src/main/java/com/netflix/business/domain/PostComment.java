package com.netflix.business.domain;

import java.util.Date;

//聚合根
public class PostComment {
	private String commentId;

	private String commentContent;

	private String commentUserId;
	// 聚合之间的引用
	private String commentPostId;

	private Date commentCreateTime;

	public PostComment() {
		super();
		// TODO Auto-generated constructor stub
		this.commentCreateTime = new Date();

	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId == null ? null : commentId.trim();
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent == null ? null : commentContent.trim();
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
		this.commentPostId = commentPostId == null ? null : commentPostId.trim();
	}

	public Date getCommentCreateTime() {
		return commentCreateTime;
	}

	public void setCommentCreateTime(Date commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}
}