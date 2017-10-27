package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.model.VersionEntity;
import com.google.business.service.VersionService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/version")
@Api(description="app版本号管理")
public class VersionController {
	@Autowired
	private VersionService versionService;
	

	
	@ApiOperation(value="查询最新版本号",notes="(IOS：type=1；Android：type=2)")
	@PostMapping("/getVersion")
	public Result getVersion(@RequestParam String type){
		VersionEntity ve = new VersionEntity();
		ve.setType(type);
		return  ResultUtil.success(versionService.getVersion(ve));
	}

}
