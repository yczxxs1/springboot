package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.model.Police;
import com.google.business.service.PoliceService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/police")
@Api(description="警用信息")
public class PoliceController {
	@Autowired
	private PoliceService policeService;
	
	@ApiOperation("完善警用信息")
	@PostMapping("/savePolice")
	public Result savePolice(Police police,String areaId){
		policeService.saveOrUpdatePolice(police, areaId);
		return ResultUtil.success();
	}
	
	@ApiOperation(value="获取警用详情")
	@PostMapping("/getPoliceDetail")
	public Result getPoliceDetail(@RequestParam String userId){
		return ResultUtil.success(policeService.getPoliceDetail(userId)); 
	}
}
