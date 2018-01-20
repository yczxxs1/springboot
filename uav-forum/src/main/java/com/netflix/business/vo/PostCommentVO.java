package com.netflix.business.vo;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("评论")
public class PostCommentVO {
	@ApiModelProperty("评论id")
	private String commentId;
	@ApiModelProperty("评论内容")
	private String commentContent;
	@ApiModelProperty("评论发送者姓名")
	private String commentUserName;
	@ApiModelProperty("评论发布者用户头像")
	private String commentUserAvatar;
	@ApiModelProperty("评论发布时间")
	private Date commentCreateTime;
	@ApiModelProperty("当前时间")
	private Date currentTime;
	@ApiModelProperty("评论点赞数")
	private int commentLikeCount;
	@ApiModelProperty("评论点赞状态")
	private boolean commentLikeStatus;



	private List<ReplyVO> replys;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentUserName() {
		return commentUserName;
	}

	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}

	public String getCommentUserAvatar() {
		return commentUserAvatar;
	}

	public void setCommentUserAvatar(String commentUserAvatar) {
		this.commentUserAvatar = commentUserAvatar;
	}

	public Date getCommentCreateTime() {
		return commentCreateTime;
	}

	public void setCommentCreateTime(Date commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public int getCommentLikeCount() {
		return commentLikeCount;
	}

	public void setCommentLikeCount(int commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
	}

	public boolean isCommentLikeStatus() {
		return commentLikeStatus;
	}

	public void setCommentLikeStatus(boolean commentLikeStatus) {
		this.commentLikeStatus = commentLikeStatus;
	}

	
	

	public List<ReplyVO> getReplys() {
		return replys;
	}

	public void setReplys(List<ReplyVO> replys) {
		this.replys = replys;
	}

}
