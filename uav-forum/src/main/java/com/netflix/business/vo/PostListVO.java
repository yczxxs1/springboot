package com.netflix.business.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("帖子")
public class PostListVO {
    
	@ApiModelProperty("帖子id")
	private String postId;
    @ApiModelProperty("发帖人用户名")
	private String postUserName;
    @ApiModelProperty("发帖人头像")
	private String postUserAvatar;
    @ApiModelProperty("帖子标题")
	private String postTitle;
    @ApiModelProperty("帖子内容")
   	private String postContent;
    @ApiModelProperty("创建时间")
	private Date postCreateTime;
    @ApiModelProperty("当前时间")
	private Date currentTime;
    @ApiModelProperty("是否有帖子图片")
	private boolean hasPostImg;
    @ApiModelProperty("评论数")
	private int commentCount;
    @ApiModelProperty("访问量")
	private int postViews;
    @ApiModelProperty("点赞数")
	private int postLikeCount;
    @ApiModelProperty("帖子点赞状态")
	private boolean postLikeStatus;
    
    public boolean isPostLikeStatus() {
		return postLikeStatus;
	}

	public void setPostLikeStatus(boolean postLikeStatus) {
		this.postLikeStatus = postLikeStatus;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
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

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Date getPostCreateTime() {
		return postCreateTime;
	}

	public void setPostCreateTime(Date postCreateTime) {
		this.postCreateTime = postCreateTime;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public boolean isHasPostImg() {
		return hasPostImg;
	}

	public void setHasPostImg(boolean hasPostImg) {
		this.hasPostImg = hasPostImg;
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

}
