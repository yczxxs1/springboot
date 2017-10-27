package com.google.business.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.business.dto.PageDTO;
import com.google.business.model.Activity;
import com.google.business.model.Activity.MOBILELIST;
import com.google.business.service.ActivityService;
import com.google.common.exception.ServiceException;
import com.google.common.io.Files;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/activity")
@Api(description="活动")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;

	@GetMapping("/id")@ApiOperation("获取活动id")
	public Result getActivityId() {
		String guid = activityService.getActivityId();
/*		System.out.println("___________________________+"+guid);
*/		return ResultUtil.success(guid);
	}
	
	@GetMapping("/{id}")@ApiOperation("获取活动详情")
	public Result getActivityDetail(@PathVariable String id) {
		return ResultUtil.success(activityService.getDetail(id));
	}
	
	@GetMapping("/list")@ApiOperation(value="获取活列表",notes="参数userId,review(0待审核,1审核不通过,2审核通过)")
	public Result getActivityList(@Validated(MOBILELIST.class) Activity activity,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size) {	
		PageHelper.startPage(page, size);
		PageInfo<Activity> pageInfo = new PageInfo<Activity>(activityService.getActList(activity));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
	
	@GetMapping("/getActList")@ApiOperation(value="web获取活动列表（分页）",notes="参数areaId")
	public Result getActList(Activity activity,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size) {	
		PageHelper.startPage(page, size);
		PageInfo<Activity> pageInfo = new PageInfo<Activity>(activityService.getActList1(activity));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
	
	@GetMapping("/historyList")@ApiOperation(value="获取活历史列表")
	public Result getHistoryList(@RequestParam String userId,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size) {
		Activity activity=new Activity();
		activity.setUserId(userId);
		PageHelper.startPage(page, size);
		PageInfo<Activity> pageInfo = new PageInfo<Activity>(activityService.getHistoryList(activity));
		return ResultUtil.success(new PageDTO(pageInfo));
	
	}
	
	@DeleteMapping("/{id}")@ApiOperation("删除活动")
	public Result delete(@PathVariable String id) {
		activityService.delActivity(id);
		return ResultUtil.success();
	}
	
	@PostMapping("/delete/batch")@ApiOperation("批量删除活动")
	public Result deleteBatch(@RequestParam String activityIds) {
		List<String> list=(List<String>) JSON.parseArray(activityIds,String.class);
		for(String id:list){
			activityService.delActivity(id);
		}
		return ResultUtil.success();
	}
	
	@PostMapping("/review")@ApiOperation(value="审核活动",notes="参数id;review;remarks(审核备注)")
	public Result review(@RequestParam String id,@RequestParam String review, String remarks) {
		Activity act = new Activity();
		act.setId(id);
		act.setReview(review);
		act.setRemarks(remarks);
		activityService.reviewActivity(act);
		return ResultUtil.success();
	}
	
	@PostMapping@ApiOperation(value="新增活动",notes="id:活动id,activity:活动名称,organizers:主办方名称,contractorId:承办人身份证,contractorName:承办人姓名,contractorPhone:承办人电话,startTime,endTime,areaId,address,userId")
	public Result save(@RequestParam("orgPhoto") MultipartFile[] orgPhotos,@RequestParam("securePhoto") MultipartFile[] securePhotos, String jsonStr)
			throws Exception {
		if (orgPhotos.length == 0||securePhotos.length == 0) {
			throw new ServiceException("You failed to upload because the file was empty.");
		}
		//主办方资质照片
		List<File> deskFiles = new ArrayList<File>();
		for (int i = 0; i < orgPhotos.length; i++) {
			String name = orgPhotos[i].getOriginalFilename();
			File desk = new File(name);
			Files.write(orgPhotos[i].getBytes(), desk);
			deskFiles.add(desk);
		}
		//安全许可材料照片
		List<File> deskFiles1 = new ArrayList<File>();
		for (int i = 0; i < securePhotos.length; i++) {
			String name = securePhotos[i].getOriginalFilename();
			File desk = new File(name);
			Files.write(securePhotos[i].getBytes(), desk);
			deskFiles1.add(desk);
		}
		Activity activity = JSON.parseObject(jsonStr, Activity.class);
		activityService.createActivity(activity, deskFiles,deskFiles1);
		return ResultUtil.success();
	}


}
