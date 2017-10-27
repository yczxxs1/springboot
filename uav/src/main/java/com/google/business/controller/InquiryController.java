package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.service.InquiryService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/inquiry")
@Api(description="精确查询")
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
	@ApiOperation(value="查询列表",notes="参数id(SN编号或者身份证号)")
	@PostMapping("/getList")
	public Result getInquiryList(@RequestParam String id){
		return  ResultUtil.success(inquiryService.getList(id));
	}

}
