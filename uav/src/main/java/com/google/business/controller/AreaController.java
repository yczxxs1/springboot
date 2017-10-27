package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.model.Area;
import com.google.business.model.City;
import com.google.business.model.Province;
import com.google.business.service.AreaService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/area")
@Api(description="区域信息")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@ApiOperation("获取省")
	@PostMapping("/getProvince")
	public Result getProvince(Province province){
		return  ResultUtil.success(areaService.selectProvince(province));
	}
	
	@ApiOperation(value="获取市",notes="传cityFatherId值为上一级的id")
	@PostMapping("/getCity")
	public Result getCity(City city){
		return  ResultUtil.success(areaService.selectCity(city));
	}
	
	@ApiOperation(value="获取区域",notes="传areaFatherId值为上一级的id")
	@PostMapping("/getArea")
	public Result getArea(Area area){
		return  ResultUtil.success(areaService.selectArea(area));
	}

	@ApiOperation(value="获取无锡市信息")
	@PostMapping("/getWuxi")
	public Result getWuxi(){
		return ResultUtil.success(areaService.getWuxi());
		
	}
	
	@ApiOperation(value="获取无锡市下区域信息")
	@PostMapping("/getWuxiArea")
	public Result getWuxiArea(){
		return ResultUtil.success(areaService.getWuxiArea());
		
	}
	

}
