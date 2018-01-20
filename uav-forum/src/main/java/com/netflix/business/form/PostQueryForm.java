package com.netflix.business.form;

import io.swagger.annotations.ApiParam;

public class PostQueryForm {
	/*private final static String postCreateTime="postCreateTime";
	
	private final static String postLikeCount="postLikeCount";
	
	private final static String commentCount="commentCount";*/
	
	@ApiParam("排序字段,值为latestComment最新评论;postHeat帖子热度;其他任意值即按照帖子发布时间倒序")
	private String postSortField;
	

	public String getPostSortField() {
		return postSortField;
	}

	public void setPostSortField(String postSortField) {
		//与前端沟通，不做校验了
		/*if (!postCreateTime.equals(postSortField) && !postLikeCount.equals(postSortField)
				&& !commentCount.equals(postSortField)) {
			throw new IllegalArgumentException("the params are not correct!");
		}*/
		this.postSortField = postSortField;
	}
}
