package com.netflix.business.condition;

import java.util.Date;

public class QueryCondition {

	private String postSortField;

	private String postUserId;

	private Date myPostListVisitTime;

	private String postId;

	private String commentPostId;

	private String replyCommentId;

	private Date postListVisitTime;
	
	

	public Date getMyPostListVisitTime() {
		return myPostListVisitTime;
	}

	public void setMyPostListVisitTime(Date myPostListVisitTime) {
		this.myPostListVisitTime = myPostListVisitTime;
	}

	public String getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(String replyCommentId) {
		this.replyCommentId = replyCommentId;
	}

	public String getCommentPostId() {
		return commentPostId;
	}

	public void setCommentPostId(String commentPostId) {
		this.commentPostId = commentPostId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	
	public Date getPostListVisitTime() {
		return postListVisitTime;
	}

	public void setPostListVisitTime(Date postListVisitTime) {
		this.postListVisitTime = postListVisitTime;
	}

	public String getPostUserId() {
		return postUserId;
	}

	public void setPostUserId(String postUserId) {
		this.postUserId = postUserId;
	}

	public String getPostSortField() {
		return postSortField;
	}

	public void setPostSortField(String postSortField) {
		this.postSortField = postSortField;
	}

}
