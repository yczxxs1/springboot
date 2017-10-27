package com.google.business.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.business.dto.PageDTO;
import com.google.business.model.User;
import com.google.business.service.UserService;
import com.google.common.exception.ServiceException;
import com.google.common.io.Files;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("user")
@Api(description = "注册用户相关操作")
public class UserController {
	@Autowired
	private UserService userService;

	@ApiOperation(value = "注册用户", notes = "userType:0个人 1单位 2销售单位 3警用")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "用户名", type = "String", paramType = "query"),
			@ApiImplicitParam(name = "sex", value = "性别", paramType = "query"),
			@ApiImplicitParam(name = "userType", value = "用户类型", paramType = "query"),
			@ApiImplicitParam(name = "password", value = "密码", paramType = "query"),
			@ApiImplicitParam(name = "nikeName", value = "姓名", paramType = "query"),
			@ApiImplicitParam(name = "showName", value = "昵称", paramType = "query"),
			@ApiImplicitParam(name = "certType", value = "证件类型", paramType = "query"),
			@ApiImplicitParam(name = "certNumber", value = "证件号码", paramType = "query"), })
	@PostMapping("/register")
	public Result register(User user) {
		userService.register(user);
		return ResultUtil.success();
	}

	@ApiOperation("登录")
	@PostMapping("/login")
	public Result login(@ApiParam("用户名") @RequestParam String userName, @ApiParam("密码") @RequestParam String password) {
		return ResultUtil.success(userService.login(userName, password));
	}

	@ApiOperation("忘记密码")
	@PostMapping("/forgetPassword")
	public Result forget(@RequestParam String mobile, @ApiParam("验证码") @RequestParam String code,
			@RequestParam String password) {
		userService.forget(mobile, code, password);
		return ResultUtil.success();

	}
	
	@ApiOperation("删除用户")
	@PostMapping("/delete/batch")
	public Result delete(@RequestParam String userIds) {
		List<String> list=(List<String>) JSON.parseArray(userIds,String.class);
		for(String id:list){
			userService.delete(id);
		}
		return ResultUtil.success();
	}

	@ApiOperation(value = "更新昵称", notes = "传id,showName")
	@PostMapping("/update")
	public Result update(User user) {
		userService.update(user);
		return ResultUtil.success();
	}

	@ApiOperation(value = "更新头像",notes="传id以json形式，如{\"id\":\"1\"}")
	@PostMapping(value="/updateAvata")
	public Result updateAvata(@RequestParam("file") MultipartFile file, @RequestParam String jsonStr) throws Exception {
		if (file == null) {
			throw new ServiceException("You failed to upload because the file was empty.");
		}
		List<File> deskFiles = new ArrayList<File>();

		String name = file.getOriginalFilename();
		File desk = new File(name);
		Files.write(file.getBytes(), desk);
		// files[i].transferTo(desk);
		deskFiles.add(desk);
		User user = JSON.parseObject(jsonStr, User.class);
	    return ResultUtil.success(userService.uploadAvatar(user.getId(),desk));
}

	
	@PostMapping("/get")
	public Result getUser(@RequestParam String userId){
		return ResultUtil.success(userService.getUser(userId));
	}
	
	@PostMapping("/updatePassword")
	public Result updatePassword(@RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String userId){
		userService.updatePassword(oldPassword, newPassword, userId);
		return ResultUtil.success();
		
	}
	
	@ApiOperation(value="获取用户列表（四种角色）")
	@PostMapping("/getUserList")
	public Result getUserList( User user,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size){
		PageHelper.startPage(page, size);
		PageInfo<User> pageInfo = new PageInfo<User>(userService.getUserList(user));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
	
	@ApiOperation(value="获取用户详情")
	@PostMapping("/getUserDetail")
	public Result getUserDetail(@RequestParam String userId){
		return ResultUtil.success(userService.getUserDetail(userId)); 
	}
}
