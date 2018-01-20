package com.kaituo.communitypolicing.business.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.kaituo.communitypolicing.business.domain.Bungalow;
import com.kaituo.communitypolicing.business.domain.Coordinate;
import com.kaituo.communitypolicing.business.domain.Floor;
import com.kaituo.communitypolicing.business.domain.House;
import com.kaituo.communitypolicing.business.domain.Person;
import com.kaituo.communitypolicing.business.service.BuildingService;
import com.kaituo.communitypolicing.business.service.PersonService;
import com.kaituo.communitypolicing.business.vo.BuildingVo;
import com.kaituo.communitypolicing.business.vo.FloorVo;
import com.kaituo.communitypolicing.business.vo.HouseOrBungalowVo;
import com.kaituo.communitypolicing.business.vo.PersonListVo;
import com.kaituo.communitypolicing.business.vo.TallBuildingVo;
import com.kaituo.communitypolicing.business.vo.UnitBriefVo;
import com.kaituo.communitypolicing.common.exception.ServiceException;
import com.kaituo.communitypolicing.common.result.ResultUtil;
import com.kaituo.communitypolicing.common.result.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/building")
@Api(tags = "建筑物")
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private PersonService personService;
	
	private final static Integer buildingListPage=1; 
	
	private final static Integer buildingListSize=10;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/listByCurrentCoordinate")
	@ApiOperation(value="根据当前坐标查看建筑物列表",notes="返回前10条")
	public ResultVo<BuildingVo> listByCurrentCoordinate(@RequestParam @ApiParam("纬度")Double longitude,@RequestParam @ApiParam("经度")Double latitude) {
		
		PageHelper.startPage(buildingListPage, buildingListSize);
		
		return ResultUtil.success(new BuildingVo(buildingService.listByCurrentCoordinates(new Coordinate( longitude, latitude))));
		
	}
	
	
	@GetMapping("{buildingId}/units")
	@ApiOperation(value="查询非独栋建筑物单元信息")
	public ResultVo<List<UnitBriefVo>> getTallBuildingUnits(@PathVariable String buildingId) throws Exception {
		return ResultUtil.success(modelMapper.map(buildingService.getTallBuilding(buildingId), TallBuildingVo.class).getUnits());
		
		
	}
	
	@GetMapping("{unitId}/floors")
	@ApiOperation(value="根据单元查看楼层信息")
	public ResultVo<List<FloorVo>> listFloors(@PathVariable String unitId){
		List<Floor> floors=buildingService.getFloors(unitId);
		List<FloorVo> floorVos = modelMapper.map(floors,new TypeToken<List<FloorVo>>() {}.getType());
		return ResultUtil.success(floorVos);
		
	}
	
	@GetMapping("houseOrBungalow/{houseOrBungalowId}")
	@ApiOperation(value="查看非层户结构房屋信息或层户结构室的信息")
	public ResultVo<HouseOrBungalowVo> getHouseOrBungalow(@PathVariable@ApiParam("室的id或平房的id") String houseOrBungalowId,@RequestParam @ApiParam("house代表室的详情或bungalow代表平房的详情")String type){
		
		  if("house".equals(type)) {
			  //室的信息以及室内人员信息
	    	   House house=buildingService.getHouse(houseOrBungalowId);
				HouseOrBungalowVo houseVo=modelMapper.map(house, HouseOrBungalowVo.class);
				houseVo.setHouseOrBungalowId(house.getHouseId());
				houseVo.setHouseFullNameOrBungalowName(house.getHouseName());
				List<Person> persons=personService.listByHouseId(houseOrBungalowId);
				List<PersonListVo> personListVos = modelMapper.map(persons,new TypeToken<List<PersonListVo>>() {}.getType());
				houseVo.setPersons(personListVos);
				return   ResultUtil.success(houseVo);
	       }else if("bungalow".equals(type)) {
	    	   
	    	 //独栋的信息以及独栋内人员信息
	    	   Bungalow bungalow=buildingService.getBungalow(houseOrBungalowId);
				HouseOrBungalowVo bungalowVo=modelMapper.map(bungalow, HouseOrBungalowVo.class);
				bungalowVo.setHouseOrBungalowId(bungalow.getBuildingId());
				bungalowVo.setHouseFullNameOrBungalowName(bungalow.getBuildingName());
				List<Person> persons=personService.listByBungalowId(houseOrBungalowId);
				List<PersonListVo> personListVos = modelMapper.map(persons,new TypeToken<List<PersonListVo>>() {}.getType());
				bungalowVo.setPersons(personListVos);
				return ResultUtil.success(bungalowVo);
	    	   
	       }else {
	    	   throw new ServiceException("瞎传！");
	       }
		
		
		
	
	}
			
	
			


}
