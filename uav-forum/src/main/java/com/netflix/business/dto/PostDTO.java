package com.netflix.business.dto;

import java.util.Date;
import java.util.List;

import com.netflix.business.domain.PostImg;

public class PostDTO {
	private String postId;

	private String postTitle;

	private String postContent;

	private String postUserId;

	private Date postCreateTime;

	private String postUserName;

	private String postUserAvatar;

	private Date currentTime;

	private int postImgCount;

	private int commentCount;

	private int postViews;

	private int postLikeCount;

	private Integer latestCommentCount;

	private boolean postLikeStatus;

	private List<PostImg> postImgs;

	private List<PostCommentDTO> postComments;

	public Integer getLatestCommentCount() {
		return latestCommentCount;
	}

	public void setLatestCommentCount(Integer latestCommentCount) {
		this.latestCommentCount = latestCommentCount;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostUserId() {
		return postUserId;
	}

	public void setPostUserId(String postUserId) {
		this.postUserId = postUserId;
	}

	public Date getPostCreateTime() {
		return postCreateTime;
	}

	public void setPostCreateTime(Date postCreateTime) {
		this.postCreateTime = postCreateTime;
	}

	public String getPostUserName() {
		return postUserName;
	}

	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}

	public String getPostUserAvatar() {
		return postUserAvatar;
	}

	public void setPostUserAvatar(String postUserAvatar) {
		this.postUserAvatar = postUserAvatar;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public int getPostImgCount() {
		return postImgCount;
	}

	public void setPostImgCount(int postImgCount) {
		this.postImgCount = postImgCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getPostViews() {
		return postViews;
	}

	public void setPostViews(int postViews) {
		this.postViews = postViews;
	}

	public int getPostLikeCount() {
		return postLikeCount;
	}

	public void setPostLikeCount(int postLikeCount) {
		this.postLikeCount = postLikeCount;
	}

	public boolean isPostLikeStatus() {
		return postLikeStatus;
	}

	public void setPostLikeStatus(boolean postLikeStatus) {
		this.postLikeStatus = postLikeStatus;
	}

	public List<PostImg> getPostImgs() {
		return postImgs;
	}

	public void setPostImgs(List<PostImg> postImgs) {
		this.postImgs = postImgs;
	}

	public List<PostCommentDTO> getPostComments() {
		return postComments;
	}

	public void setPostComments(List<PostCommentDTO> postComments) {
		this.postComments = postComments;
	}

	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
		currentTime = new Date();
	}

}
