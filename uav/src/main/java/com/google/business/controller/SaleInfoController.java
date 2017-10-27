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
import com.google.business.model.SaleInfoEntity;
import com.google.business.service.SaleInfoService;
import com.google.common.exception.ServiceException;
import com.google.common.io.Files;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/saleInfo")
public class SaleInfoController {
	@Autowired
	private SaleInfoService saleInfoService;

	@ApiOperation(value = "增加销售信息", notes = "参数：name phone ownerid：拥有者身份证  sn vendorid：销售单位编号  "
			+ "factoryModelId：生产厂商id uavModel：无人机型号id ownerType")
	@PostMapping("/add")
	public Result addSaleInfo(@RequestParam String jsonStr, @RequestParam("file") MultipartFile[] files)
			throws Exception {
		if (files.length == 0) {
			throw new ServiceException("You failed to upload because the file was empty");
		} else {
			List<File> deskFiles = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				String name = files[i].getOriginalFilename();
				File desk = new File(name);
				// files[i].transferTo(desk);
				Files.write(files[i].getBytes(), desk);
				deskFiles.add(desk);
			}
			saleInfoService.addSaleInfo(JSON.parseObject(jsonStr, SaleInfoEntity.class), deskFiles);
			return ResultUtil.success();
		}
	}

	@ApiOperation(value = "销售列表数量", notes = "1>  mobile获取销售列表数量    参数：ownerid  regstatus=0")
	@PostMapping("/count")
	public Result saleInfoCount(SaleInfoEntity saleInfo) {
		int count = saleInfoService.saleInfoCount(saleInfo);
		return ResultUtil.success(count);
	}

	@ApiOperation(value = "检查sn编码在销售表中是否存在", notes = "1>  mobile检查sn编码在销售表中是否存在    参数：sn")
	@PostMapping("/checkSn")
	public Result checkSn(SaleInfoEntity saleInfo) {
		saleInfoService.checkSn(saleInfo);
		return ResultUtil.success();
	}


	/*@ApiOperation(value="销售信息详情",notes="1>  mobile查询销售信息详情    参数：id")
	@PostMapping("/detail")
	public Result saleInfodetail(SaleInfoEntity saleInfo) {
		return ResultUtil.success(saleInfoService.saleInfodetail(saleInfo));
	}*/

	@ApiOperation(value = "销售列表", notes = "1>  mobile查询销售列表    参数：vendorid regstatus=0  page size")
	@PostMapping("/list")
	public Result saleInfolist(SaleInfoEntity saleInfo, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		PageInfo<SaleInfoEntity> pageInfo = new PageInfo<SaleInfoEntity>(saleInfoService.saleInfolist(saleInfo));
		return ResultUtil.success(new PageDTO(pageInfo));
	}

	@ApiOperation(value = "某区域内的销售列表", notes = "1>  web查询某区域内的销售列表    参数：areaId page size "
												+ "2> web端过滤查询   参数：areaId 下面参数可有可无(name:拥有者姓名   factModelName:厂商名称   regstatus:状态)")
	@PostMapping("/areaList")
	public Result saleInfolistByareaId(SaleInfoEntity saleInfo, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		PageInfo<SaleInfoEntity> pageInfo = new PageInfo<SaleInfoEntity>(saleInfoService.saleInfolistByareaId(saleInfo));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
}
