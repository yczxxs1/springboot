package com.netflix.business.form;

import org.apache.commons.lang3.StringUtils;

public class PostForm {

	private String postTitle;
	private String postContent;
	private String postUserId;

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

	public void validate() {
		if (StringUtils.isEmpty(getPostTitle()) || StringUtils.isEmpty(getPostContent())
				|| StringUtils.isEmpty(getPostUserId())) {
			throw new IllegalArgumentException("the params are not correct!");
		}
	}

}
