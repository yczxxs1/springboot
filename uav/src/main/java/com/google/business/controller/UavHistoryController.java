package com.google.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.model.UavHistoryEntity;
import com.google.business.service.UavHistoryService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/uavHistory")
public class UavHistoryController {
	@Autowired
	private UavHistoryService uavHistoryService;
	
	@ApiOperation(value = "查看销售详情", notes = "参数：snNumber")
	@PostMapping("/saleDetail")
	public Result queryUavDetail(UavHistoryEntity uav){
		List<UavHistoryEntity> saleDetail =  uavHistoryService.querySaleDetail(uav);
		return ResultUtil.success(saleDetail);
	}
}
