package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.model.RotationEntity;
import com.google.business.service.RotationService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rotation")
@Api(description="轮播")
public class RotationController {
	@Autowired
	private RotationService rotationService;
	
	@ApiOperation("查询")
	@PostMapping("/listOne")
	public Result oneDetail(@RequestParam String type){
		RotationEntity rotationEntity=new RotationEntity();
		rotationEntity.setType(type);
		return  ResultUtil.success(rotationService.getOne(rotationEntity));
	}
	
	
}
