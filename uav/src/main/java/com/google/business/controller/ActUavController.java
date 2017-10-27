package com.google.business.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.business.dto.PageDTO;
import com.google.business.model.ActUav;
import com.google.business.service.ActUavService;
import com.google.common.exception.ServiceException;
import com.google.common.io.Files;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/actUav")
@Api(description="活动无人机")
public class ActUavController {
	@Autowired
	private ActUavService actUavService;
	
	
	@ApiOperation(value = "新增活动无人机", notes = "参数：actId:活动id,card:无人机识别卡,userNumber:驾驶员身份证号码 ,snNumber,userName驾驶员姓名,userPhone")
    @PostMapping("/createActUav")
	public Result handleMultipartiJsonFileUpload(@RequestParam("file") MultipartFile[] files,
			@RequestParam String jsonStr) throws Exception {
		if (files.length == 0) {
			throw new ServiceException("You failed to upload because the file was empty");
		} else {
			List<File> deskFiles = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				String name = files[i].getOriginalFilename();
				File desk = new File(name);
				Files.write(files[i].getBytes(), desk);
				deskFiles.add(desk);
			}
			actUavService.createActUav(JSON.parseObject(jsonStr, ActUav.class), deskFiles);
			return ResultUtil.success();
		}
	}
	
	@ApiOperation(value="查询活动无人机列表",notes="参数：actId(活动id);page size")
	@PostMapping("/getActUavList") //belongId page size
	public Result getActUavs(ActUav actUav,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size){
			PageHelper.startPage(page, size);
			PageInfo<ActUav> pageInfo = new PageInfo<ActUav>(actUavService.getActUavList(actUav));
			return ResultUtil.success(new PageDTO(pageInfo));
	}
	
	@ApiOperation(value="查询当前活动已添加无人机驾驶员",notes="参数：actId(活动id)")
	@PostMapping("/getAU") //belongId page size
	public Result getAU(@RequestParam String actId){
		    ActUav actUav = new ActUav();
		    actUav.setActId(actId);
			return ResultUtil.success( actUavService.getAUList(actUav));
	}
	
	@ApiOperation(value = "审核无人机")
	@PostMapping("/review")
	public Result review(@RequestParam String review,@RequestParam String id) {
		ActUav au = new ActUav();
		au.setReview(review);
		au.setId(id);
		actUavService.review(au);
		return ResultUtil.success();
	}
	
	@ApiOperation(value = "删除无人机")
	@PostMapping("/delete")
	public Result deleteActUav(@RequestParam String id) {
		actUavService.delActUav(id);
		return ResultUtil.success();
	}
	
	@ApiOperation(value = "查看活动无人机详情")
	@PostMapping("/getDetail")
	public Result getDetail(@RequestParam String id) {
		ActUav au = new ActUav();
		au.setId(id);
		return ResultUtil.success(actUavService.getDetail(au));
	}
}
