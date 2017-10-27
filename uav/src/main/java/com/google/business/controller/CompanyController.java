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
import com.google.business.model.Companys;
import com.google.business.service.CompanyService;
import com.google.common.exception.ServiceException;
import com.google.common.io.Files;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/company")
@Api(description="单位")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("save")
	@ApiOperation(value = "完善单位信息", notes = "将表单数据转成json报文 key为jsonStr，文件上传字段都为file")
	@ApiImplicitParams({ @ApiImplicitParam(name = "jsonStr", value = "", type = "String", example = "将以下字段组成json报文"),
			@ApiImplicitParam(name = "certType", value = "证照类型0=统一社会信用代码1=组织机构代码", paramType = "query"),
			@ApiImplicitParam(name = "certNumber", value = "证照号码", paramType = "query"),
			@ApiImplicitParam(name = "corporation", value = "法人", paramType = "query"),
			@ApiImplicitParam(name = "address", value = "单位地址", paramType = "query"),
			@ApiImplicitParam(name = "companyEmail", value = "单位邮箱", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "单位名称", paramType = "query"),
			@ApiImplicitParam(name = "corporationNumber", value = "法人身份证号", paramType = "query"),
			@ApiImplicitParam(name = "area.areaId", value = "最低一级区域id", paramType = "query"),
			@ApiImplicitParam(name = "userId", value = "用户id", paramType = "query") })
	public Result saveCompany(@RequestParam("file") MultipartFile[] files, @RequestParam String jsonStr)
			throws Exception {
		if (files.length == 0) {
			throw new ServiceException("You failed to upload because the file was empty.");
		}
		List<File> deskFiles = new ArrayList<File>();
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getOriginalFilename();
			File desk = new File(name);
			Files.write(files[i].getBytes(), desk);
			// files[i].transferTo(desk);
			deskFiles.add(desk);
		}
		Companys company = JSON.parseObject(jsonStr, Companys.class);
		companyService.saveOrUpdate(company, deskFiles);
		return ResultUtil.success(companyService.getCompanyPhotoByCompanyId(company.getId()));
	}
	
	@ApiOperation(value="获取单位详情")
	@PostMapping("/getCompanyDetail")
	public Result getCompanyDetail(@RequestParam String userId){
		return ResultUtil.success(companyService.getCompanyDetail(userId)); 
	}

}
