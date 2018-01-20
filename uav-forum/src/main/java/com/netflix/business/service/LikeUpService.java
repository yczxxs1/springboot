package com.netflix.business.service;

public interface LikeUpService {
	
	/**
	 * 获取点赞状态
	 * @param ObjectId
	 * @param userId
	 * @return
	 */
	boolean getLikeUpStatus(String objectId,String userId) ;
	
	/**
	 * 点赞或取消点赞
	 * @param ObjectId
	 * @param userId
	 * @return true为点赞,false为取消点赞
	 */
    Boolean likeOrCancelLike(String objectId,String userId);

}
