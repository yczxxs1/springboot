package com.netflix.business.domain;

import java.util.Date;

//聚合根
public class Post {
	private String postId;
   
	private String postTitle;
    
	private String postContent;
	// 聚合之间的引用
	private String postUserId;

	private Date postCreateTime;

	
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
		postCreateTime=new Date();
	}
	
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId == null ? null : postId.trim();
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle == null ? null : postTitle.trim();
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent == null ? null : postContent.trim();
	}

	public String getPostUserId() {
		return postUserId;
	}

	public void setPostUserId(String postUserId) {
		this.postUserId = postUserId == null ? null : postUserId.trim();
	}

	public Date getPostCreateTime() {
		return postCreateTime;
	}

	public void setPostCreateTime(Date postCreateTime) {
		this.postCreateTime = postCreateTime;
	}


}