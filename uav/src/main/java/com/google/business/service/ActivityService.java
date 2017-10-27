package com.google.business.service;

import java.io.File;
import java.util.List;

import com.google.business.model.Activity;

public interface ActivityService {
	void createActivity(Activity activity,List<File> files1,List<File> files2) throws Exception;
	void delActivity(String id);
	void delAct(String id);
	void reviewActivity(Activity activity);
	List<Activity> getActList(Activity activity);
	List<Activity> getActList1(Activity activity);
	List<Activity> getHistoryList(Activity activity);
	Activity getDetail(String id);
	String getActivityId();
}
