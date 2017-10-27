package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.conversion.LocationConversion;
import com.google.business.form.LocationForm;
import com.google.business.service.LocationService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private LocationConversion locationConversion;

	@ApiOperation(value="一天的坐标点位",notes="传areaId")
	@PostMapping("/theDay")
	public Result queryForTwoHours(LocationForm locationForm){
		return ResultUtil.success(locationService.getLocationInfoForTheDay(locationConversion.converToDTO(locationForm)));
	}
	
	@ApiOperation(value="某个时间段的坐标点位",notes="startTime开始时间,endTime结束时间;时间格式yyyy-MM-dd HH:mm:ss")
	@PostMapping("/period")
	public Result queryListForTime(LocationForm locationForm){
		return ResultUtil.success(locationService.getLocationForTime(locationConversion.converToDTO(locationForm)));
	}
	
}
