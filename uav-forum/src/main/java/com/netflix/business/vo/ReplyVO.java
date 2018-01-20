package com.netflix.business.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("回复")
public class ReplyVO {
	@ApiModelProperty("回复id")
	private String replyId;
	@ApiModelProperty("回复者姓名")
	private String replyUserName;
	@ApiModelProperty("回复者头像")
	private String replyUserAvatar;
	@ApiModelProperty("回复内容")
	private String replyContent;
	@ApiModelProperty("回复发布时间")
	private Date replyCreateTime;
	@ApiModelProperty("当前时间")
	private Date currentTime;

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
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

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyCreateTime() {
		return replyCreateTime;
	}

	public void setReplyCreateTime(Date replyCreateTime) {
		this.replyCreateTime = replyCreateTime;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

}
