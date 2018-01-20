package com.netflix.business.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("评论详情")
public class PostDetailVO extends PostListVO{


	@ApiModelProperty("帖子图片")
	private List<PostImgVO> postImgs;

	public List<PostImgVO> getPostImgs() {
		return postImgs;
	}

	public void setPostImgs(List<PostImgVO> postImgs) {
		this.postImgs = postImgs;
	}


}
