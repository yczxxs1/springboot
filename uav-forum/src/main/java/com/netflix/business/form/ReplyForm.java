package com.netflix.business.form;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiParam;

public class ReplyForm {
    @ApiParam(value="回复内容",required=true)
    @NotEmpty
	private String replyContent;
    
    @ApiParam(value="回复发布者id",required=true)
    @NotEmpty
	private String replyUserId;

    @ApiParam(value="评论id",required=true)
    @NotEmpty
	private String replyCommentId;

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
		this.replyCommentId = replyCommentId;
	}

}
