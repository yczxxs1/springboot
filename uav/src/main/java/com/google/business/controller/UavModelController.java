package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.model.FactoryEntity;
import com.google.business.model.UavModelEntity;
import com.google.business.service.UavModelService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/uavModel")
public class UavModelController {
	@Autowired
	private UavModelService uavModelService;
	
	@PostMapping("/findUavModel")
	@ApiOperation("暂时废弃")
	public Result findUavModel(){
		return ResultUtil.success(uavModelService.getUavModel(new UavModelEntity()));
	}
	

	@ApiOperation("获取厂商和型号")
	@PostMapping("/findFactory")
	public Result findFactory(){
		return ResultUtil.success(uavModelService.getFactoryMsg(new FactoryEntity()));
	}
}
