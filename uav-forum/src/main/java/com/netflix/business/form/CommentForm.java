package com.netflix.business.form;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiParam;

public class CommentForm {
    @ApiParam(value="评论内容",required=true)
    @NotEmpty
	private String commentContent;
    
    @ApiParam(value="当前用户id",required=true)
    @NotEmpty
	private String commentUserId;
    
    @ApiParam(value="帖子id",required=true)
    @NotEmpty
	private String commentPostId;

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
		this.commentPostId = commentPostId;
	}

}
