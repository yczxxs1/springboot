package com.netflix.business.service;

import java.io.File;
import java.util.List;

import com.netflix.business.condition.QueryCondition;
import com.netflix.business.domain.Post;
import com.netflix.business.dto.PostDTO;

public interface PostService {

	/**
	 * 
	 * @param post
	 * @param files
	 *            图片数组
	 * @throws Exception
	 */
	public void post(Post post, List<File> files) throws Exception;

	/**
	 * 查询帖子列表
	 * @param queryCondition 查询条件
	 * @return
	 * @throws Exception
	 */
	public List<PostDTO> listPost(QueryCondition queryCondition) throws Exception;

	/**
	 * 用户查看帖子列表
	 * 
	 * @param queryCondition
	 * @param loginUserId
	 * @return
	 * @throws Exception
	 */
	public List<PostDTO> listPost(QueryCondition queryCondition, String loginUserId) throws Exception;

	/**
	 * 查询帖子详情
	 * 
	 * @param postId
	 * @return
	 * @throws Exception
	 */
	public PostDTO getPost(String postId) throws Exception;

	/**
	 * 发布访问帖子列表事件
	 * 
	 * @param isMyPostList
	 * @param loginUserId
	 * @throws Exception
	 * @see com.netflix.business.service.impl.ForumStatisticsImpl 
	 */
	public void publishPostListVisitEvent(boolean isMyPostList, String loginUserId) throws Exception;

	/**
	 * 发布查询详情事件
	 * @param loginUserId
	 * @param postId
	 * @throws Exception
	 * @see com.netflix.business.service.impl.ForumStatisticsImpl
	 */
	public void publishPostDetailVisitEvent(String loginUserId, String postId) throws Exception;

	/**
	 * 最新帖子数
	 * @param loginUserId
	 * @return
	 * @throws Exception
	 */
	public int countLatestPost(String loginUserId) throws Exception;

}
