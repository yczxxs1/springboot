package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.service.FencePointService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fencePoint")
@Api(description="电子围栏")
public class FencePointController {
	@Autowired
	private FencePointService fencePointService;
	

	
	@ApiOperation(value="查询电子围栏")
	@PostMapping("/getFencePoint")
	public Result getFencePoint(String userId, Double latitude, Double longitude){
		return  ResultUtil.success(fencePointService.getFencePoint(userId,latitude, longitude));
	}

}
