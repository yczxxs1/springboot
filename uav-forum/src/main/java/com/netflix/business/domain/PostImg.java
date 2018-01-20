package com.netflix.business.domain;

import java.util.Date;

//值对象
public class PostImg {
	private String postImgId;

	private String postImgUrl;

	private Integer postImgHeight;

	private Integer postImgWidth;

	private String postImgPostId;

	private Date postImgCreateTime;

	public String getPostImgId() {
		return postImgId;
	}

	public void setPostImgId(String postImgId) {
		this.postImgId = postImgId == null ? null : postImgId.trim();
	}

	public String getPostImgUrl() {
		return postImgUrl;
	}

	public void setPostImgUrl(String postImgUrl) {
		this.postImgUrl = postImgUrl == null ? null : postImgUrl.trim();
	}

	public Integer getPostImgHeight() {
		return postImgHeight;
	}

	public void setPostImgHeight(Integer postImgHeight) {
		this.postImgHeight = postImgHeight;
	}

	public Integer getPostImgWidth() {
		return postImgWidth;
	}

	public void setPostImgWidth(Integer postImgWidth) {
		this.postImgWidth = postImgWidth;
	}

	public String getPostImgPostId() {
		return postImgPostId;
	}

	public void setPostImgPostId(String postImgPostId) {
		this.postImgPostId = postImgPostId == null ? null : postImgPostId.trim();
	}

	public Date getPostImgCreateTime() {
		return postImgCreateTime;
	}

	public void setPostImgCreateTime(Date postImgCreateTime) {
		this.postImgCreateTime = postImgCreateTime;
	}

	public PostImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostImg(String postImgUrl, Integer postImgHeight, Integer postImgWidth, String postImgPostId) {
		super();
		this.postImgUrl = postImgUrl;
		this.postImgHeight = postImgHeight;
		this.postImgWidth = postImgWidth;
		this.postImgPostId = postImgPostId;
		this.postImgCreateTime = new Date();
	}

}