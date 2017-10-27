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
import com.google.business.model.LicenseEntity;
import com.google.business.model.LicenseTypeEntity;


import com.google.business.service.LicenseService;
import com.google.business.service.UserService;
import com.google.common.exception.ServiceException;
import com.google.common.io.Files;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/License")
@Api(description="证书")
public class LicenseController {
	
	@Autowired
	private LicenseService licenseService;
	@Autowired
	private UserService userService; 
	
	@PostMapping("/list")
	@ApiOperation(value="所有执照信息",notes="参数：page size")
	public Result getLicenseList(LicenseEntity licenseEntity,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size){
		PageHelper.startPage(page, size);
		PageInfo<LicenseEntity> pageInfo = new PageInfo<LicenseEntity>(licenseService.getLicenseList(licenseEntity));
		return ResultUtil.success(new PageDTO(pageInfo)); 
	}
	
	@PostMapping("/weblist")
	@ApiOperation(value="所有执照信息_web",notes="参数：page size")
	public Result getLicenseListByAreaId(LicenseEntity licenseEntity,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size){
		PageHelper.startPage(page, size);
		PageInfo<LicenseEntity> pageInfo = new PageInfo<LicenseEntity>(licenseService.getLicenseListByAreaId(licenseEntity));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
	
	@PostMapping("/listDetail")
	@ApiOperation(value="执照详细信息",notes="参数：id")
	public Result getLicenseListOne(LicenseEntity licenseEntity){
		return ResultUtil.success(licenseService.getLicenseList_Count(licenseEntity)); 
	}
	@PostMapping("/userDetail")
	@ApiOperation(value="执照所属用户信息",notes="参数：userId")
	public Result getMsgByUserId(@RequestParam String userId){
		return ResultUtil.success(userService.getUserDetail(userId));
	}
	@PostMapping("/reviewLicense")
	@ApiOperation(value="证书审核")
	public Result review(@RequestParam String licenseJson) {
		List<LicenseEntity> list = (List<LicenseEntity>) JSON.parseArray(licenseJson, LicenseEntity.class);
		for (LicenseEntity ue : list) {
			licenseService.review(ue);
		}
		return ResultUtil.success();
	}
	
	@PostMapping("/del")
	@ApiOperation(value="删除执照信息")
	public Result del(LicenseEntity licenseEntity){
		licenseService.deleteSelective(licenseEntity);
		return ResultUtil.success(); 
	}
	
	@PostMapping("/batch/delete")
	@ApiOperation(value="批量删除执照信息")
	public Result deleteBatch(@RequestParam @ApiParam("数据结构为json数组")String licenseIds){
		List<String> list=(List<String>) JSON.parseArray(licenseIds,String.class);
		licenseService.deleteBatch(list);
		return ResultUtil.success(); 
	}
	
	@PostMapping("/writeOff")
	@ApiOperation(value="执照状态",notes="参数： userId")
	public Result updateLicense(LicenseEntity licenseEntity){
		licenseService.updateSelective(licenseEntity);		
		return ResultUtil.success("注销成功"); 
	}
	
	@PostMapping("/licenseType")
	@ApiOperation(value="执照类型" )
	public Result LicenseType(LicenseTypeEntity licenseTypeEntity){
		return ResultUtil.success(licenseService.getLicenseType(licenseTypeEntity)); 
	}
	
	@PostMapping("/saveOrUpdate")
	@ApiOperation(value="保存或更新证书状态")
	public Result saveLicense(@RequestParam ("file") MultipartFile[] files,
			@RequestParam String jsonStr) throws Exception{
		if (files.length == 0) {
			throw new ServiceException("You failed to upload because the file was empty.");
		} else {
			
			 List<File> deskFiles=new ArrayList<File>();
				for (int i=0;i<files.length;i++) {
					String name = files[i].getOriginalFilename();
					File desk = new File(name);
					Files.write(files[i].getBytes(), desk);
					//files[i].transferTo(desk);
				    deskFiles.add(desk);
				}
			licenseService.saveOrUpdate(JSON.parseObject(jsonStr,LicenseEntity.class), deskFiles);
		}
		
		return ResultUtil.success();
	}
	
	@PostMapping("/count_list")
	@ApiOperation("通过的证书数和详情")
	public Result getCount_List(LicenseEntity licenseEntity,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size){
		if(licenseEntity.getUserId()==null){
			throw new ServiceException("非法！");
		}
		PageHelper.startPage(page, size);
		licenseEntity.setReview("2");
		PageInfo<LicenseEntity> pageInfo = new PageInfo<LicenseEntity>(licenseService.getLicenseList(licenseEntity));
		return ResultUtil.success(new PageDTO(pageInfo));
	}

}
