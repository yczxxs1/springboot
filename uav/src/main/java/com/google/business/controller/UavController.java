package com.google.business.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.business.dto.PageDTO;
import com.google.business.model.Aircraft;
import com.google.business.model.DictEntity;
import com.google.business.model.UavEntity;
import com.google.business.model.UavHistoryEntity;
import com.google.business.model.UavTransferEntity;
import com.google.business.service.AircraftService;
import com.google.business.service.DictService;
import com.google.business.service.UavHistoryService;
import com.google.business.service.UavService;
import com.google.common.exception.ServiceException;
import com.google.common.io.Files;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/uav")
@Api(description = "无人机相关")
public class UavController {
	@Autowired
	private UavService uavService;
	@Autowired
	private DictService dictService;
	@Autowired
	private AircraftService aircraftService;
	@Autowired
	private UavHistoryService uavHService;

	@ApiOperation(value="查询无人机列表",notes="1>mobile查询状态为登录的无人机列表   参数：belongId status=1 page size	"
			+ "2>mobile查询已审核的无人机列表   参数：belongId review=2")
	@PostMapping("/list") //belongId page size
	public Result getUavs(UavEntity uav,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size){
		if("0".equals(page)){
			return ResultUtil.success(uavService.getUavs(uav));
		}else{
			PageHelper.startPage(page, size);
			PageInfo<UavEntity> pageInfo = new PageInfo<UavEntity>(uavService.getUavs(uav));
			return ResultUtil.success(new PageDTO(pageInfo));
		}
	}

	
	@ApiOperation(value = "查看无人机数量", notes = "1>	 mobile查询已审核无人机数量   参数：belongId review=2")
	@PostMapping("/count")
	public Result getUavCount(UavEntity uav){
		if(uav.getBelongId()==null||uav.getReview()==null){
			throw new ServiceException("非法！");
		}
		int count = uavService.getUavCount(uav);
		return ResultUtil.success(count);
	}
	
	@ApiOperation(value = "查看无人机详情", notes = "1>无人机列表详情  参数：id  2>已销售列表无人机详情  参数：id")
	@PostMapping("/uavDetail") // id
	public Result queryUavDetail(UavEntity uav){
		UavEntity uavDetail = new UavEntity();
		uavDetail = uavService.queryUavDetail(uav);
		return ResultUtil.success(uavDetail);
	}
	
	@ApiOperation(value = "查看无人机详情（for精确查询）", notes = " 参数：sn（无人机SN）")
	@PostMapping("/uavInquiryDetail") // id
	public Result queryInquiryDetail(@RequestParam String sn){
		UavEntity uav = new UavEntity();
		uav.setSnNumber(sn);
		UavHistoryEntity uavH = new UavHistoryEntity();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uavDetail",uavService.queryUavDetail(uav));
		uavH.setSnNumber(sn);
		map.put("uavHistory",uavHService.querySaleDetail(uavH));
		return ResultUtil.success(map);
	}

	@ApiOperation(value = "删除无人机", notes = "参数：id")
	@ApiImplicitParam(name = "id", value = "无人机id", type = "String", paramType = "query", required = true)
	@PostMapping("/deleteUav") // id
	public Result deleteUav(UavEntity uav) {
		uavService.deleteUav(uav);
		return ResultUtil.success();
	}
	
	@ApiOperation(value = "批量删除无人机")
	@PostMapping("/batch/delete")
	public Result deleteUav(@RequestParam @ApiParam("数据结构为json数组") String uavIds) {
		 List<String> list=(List<String>) JSON.parseArray(uavIds,String.class);
		uavService.deleteUavBatch(list);
		return ResultUtil.success();
	}
	
	
	@ApiOperation(value = "检查sn编号的唯一性", notes = "参数：snNumber")
	@PostMapping("/checkOutSnNumber")
	public Result checkOurSnNumber(UavEntity uav, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "0") Integer size) {
		String words = uavService.checkOutSnNumber(uav);
		return ResultUtil.success(words);
	}

	@ApiOperation(value = "注销无人机", notes = "参数：id status=0")
	@PostMapping("/writeOffUav") // id status=0
	public Result updateWriteOffUAV(UavEntity uav) {

		uavService.updateWriteOffUAV(uav);
		return ResultUtil.success();
	}

	@ApiOperation(value = "转让无人机", notes = "参数： status=9 belongId:归属者编号 snNumber name card tel")
	@PostMapping("/transferUAV") // id status=0
	public Result transferUAV(@RequestParam String status, @RequestParam String belongId,
			UavTransferEntity uavTransfer) {
		uavService.transferUAV(status, belongId, uavTransfer);
		return ResultUtil.success();
	}

	@ApiOperation(value = "新增或更新无人机", notes = "参数：factoryId:生产厂商   id:无人机编号  modelId:无人机型号的id snNumber：sn编号  belongTo：所属类型   purpose：用途  file：图片 belongId:就是userid madeByself：是否自制 自制是0，非自制是1"
			            + "belongTpye:无人机归属类型0~13")
	@PostMapping("/createUav")
	public Result handleMultipartiJsonFileUpload(@RequestParam("file") MultipartFile[] files,
			@RequestParam String jsonStr) throws Exception {
		if (files.length == 0) {
			throw new ServiceException("You failed to upload because the file was empty");
		} else {
			List<File> deskFiles = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				String name = files[i].getOriginalFilename();
				File desk = new File(name);
				//files[i].transferTo(desk);
				Files.write(files[i].getBytes(), desk);
				deskFiles.add(desk);
			}
			uavService.createUavInfo(JSON.parseObject(jsonStr, UavEntity.class), deskFiles);
			return ResultUtil.success();
		}

	}

	@ApiOperation(value = "查询无人机用途", notes = "参数：无")
	@PostMapping("/queryUavPurposeList") // id status=0
	public Result queryDictList() {
		List<DictEntity> dictList = dictService.queryDictList("uav_purpose");
		return ResultUtil.success(dictList);
	}

	@ApiOperation(value = "查询无人机归属类型", notes = "参数：无")
	@PostMapping("/queryUavBelongType") // id status=0
	public Result queryUavBelongTypeList(Aircraft aircraft) {
		List<Aircraft> aricraftList = aircraftService.queryUavBelongTypeList(aircraft);
		return ResultUtil.success(aricraftList);
	}

	@ApiOperation(value = "非 非自制无人机情况下获取SN编码", notes = "参数：无")
	@PostMapping("/gainSNnumber") // id status=0
	public Result gainSNnumber() {
		String SNnumber = uavService.gainSNnumber();
		return ResultUtil.success(SNnumber);
	}

	@ApiOperation(value = "审核无人机")
	@PostMapping("/review")
	public Result review(@RequestParam String uavJson) {
		List<UavEntity> list = (List<UavEntity>) JSON.parseArray(uavJson, UavEntity.class);
		for (UavEntity ue : list) {
			uavService.review(ue);
		}
		return ResultUtil.success();
	}

	//web端
	@ApiOperation(value="获取无人机列表（按区域）")
	@PostMapping("/getUavList")
	public Result getUavList( UavEntity uav,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size){
		PageHelper.startPage(page, size);
		PageInfo<UavEntity> pageInfo = new PageInfo<UavEntity>(uavService.getUavList(uav));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
	
	@ApiOperation(value="修改SN编码",notes="参数：id sn")
	@PostMapping("/snEdit") //id  status=0 
	public Result snEdit(@RequestParam String id, @RequestParam String sn){
		uavService.snEdit(sn, id);
		return ResultUtil.success();
	}
	
//	@ApiOperation(value="插省市区的数据",notes="参数")
//	@PostMapping("/insertData") //id  status=0 
//	public Result insertData() throws Exception{
//		uavService.insertData();
//		return ResultUtil.success();
//	}
}
