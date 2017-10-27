package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.service.SmsService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sms")
@Api(description="手机验证码相关操作")
public class SmsController {

	@Autowired
	private SmsService smsService;
	
	@ApiOperation("获取验证码")
	@ApiImplicitParam(name="use",value="用途 0注册 1忘记密码",type="String",paramType="query")
	@PostMapping("/getCode")
	public Result sendMsg(@RequestParam String mobile, @RequestParam String use) throws Exception{
		smsService.sendMsg(mobile, use);
		return ResultUtil.success();
		
	}
	@ApiOperation("校验验证码")
	@ApiImplicitParam(name="code",value="验证码",type="String",paramType="query")
	@PostMapping("/verifyCode")
	public Result verifyCode(@RequestParam String mobile,@RequestParam String code) throws Exception{
		smsService.verifyCode(mobile, code);
		return ResultUtil.success();
	}
	
}
