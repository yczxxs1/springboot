package com.netflix.business.vo;

import io.swagger.annotations.ApiModelProperty;

public class MyPostListVO  extends PostListVO{
	

	@ApiModelProperty("最新评论数")
	private Integer latestCommentCount;

	public Integer getLatestCommentCount() {
		return latestCommentCount;
	}

	public void setLatestCommentCount(Integer latestCommentCount) {
		this.latestCommentCount = latestCommentCount;
	}

	

	



}
