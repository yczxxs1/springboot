package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.dto.ActivityDTO;
import com.google.business.model.Activity;

@Mapper
public interface ActivityDAO {
		int insertActivity(Activity activity);
		int updateActivity(Activity activity);
		int deleteActivity(String id);
		List<Activity> selectActList(ActivityDTO activity);
		List<Activity> selectReviewPass(Activity activity);
		List<Activity> selectHistoryList(Activity activity);
		Activity selectOne(Activity activity);
		Activity selectById(String id);
		String selectId();
}
