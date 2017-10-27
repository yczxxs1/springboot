package com.google.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.business.dto.PageDTO;
import com.google.business.model.AdminEntity;
import com.google.business.model.AdminEntity.CREATE;
import com.google.business.service.AdminService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
		
	@ApiOperation("登录")
	@PostMapping("/login")
	public Result longIn(@RequestParam String name,@RequestParam String password){
		return  ResultUtil.success(adminService.login(name,password));
	}
	
	
	@ApiOperation(value="创建用户信息",notes="name:登录名;真实姓名nikeName;所属部门dept;警号:policeNumber;性别:sex;手机号码phone;邮箱（选填）:email;状态（启用/停用）status(0：正常 1 禁用);账号有效期(选填)effectiveDate")
	@PostMapping("/createAdmin")
	public Result newAdmin(@Validated(CREATE.class) AdminEntity adminEntity){
		adminService.createAdmin(adminEntity);
		return ResultUtil.success(adminEntity.getId());
	}
	
	
	@ApiOperation("删除用户信息")
	@PostMapping("/del")
	public Result del(@RequestParam String userId){
		 List<String> list=(List<String>) JSON.parseArray(userId,String.class);
		 adminService.delAdminBatch(list);
		return ResultUtil.success(); 
	}
	
	@ApiOperation("获取用户信息")
	@PostMapping("/list")
	public Result getAdminList(AdminEntity adminEntity,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size){
		PageHelper.startPage(page, size);
		PageInfo<AdminEntity> pageInfo = new PageInfo<AdminEntity>(adminService.getAdminList(adminEntity));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
	
	@ApiOperation("启用和禁用 是否开放终端")
	@PostMapping("/update")
	public Result updateList(AdminEntity adminEntity){
		adminService.updateAdmin(adminEntity);
		return ResultUtil.success();
	}
	
	
	@ApiOperation("获取用户详细")
	@PostMapping("/detail")
	public Result queryDetail(@RequestParam String id){
		AdminEntity adminEntity=new AdminEntity();
		adminEntity.setId(id);
		return ResultUtil.success(adminService.getDetail(adminEntity));
	}
	
	
	@ApiOperation("重置密码")
	@PostMapping("/resetPassword")
	public Result resetPassword(@RequestParam String userId){
		 List<String> list=(List<String>) JSON.parseArray(userId,String.class);
		 adminService.resetPasswordBatch(list);
		return ResultUtil.success();
	}
	
	
	@ApiOperation("修改密码")
	@PostMapping("/editPassword")
	public Result resetPassword(@RequestParam String oldPassword,@RequestParam String newPassword,@RequestParam String userId){
		adminService.editPassword(oldPassword, newPassword, userId);
		return ResultUtil.success();
	}
}
