package com.kaituo.communitypolicing.business.vo;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class BuildingVo {
	@ApiModelProperty("地址")
	private String location;
	
	private List<BuildingListVo> buildings;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<BuildingListVo> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<BuildingListVo> buildings) {
		this.buildings = buildings;
	}

	public BuildingVo() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	public BuildingVo(List<BuildingListVo> buildings) {
		super();
		this.location="南京市雨花台区";
		this.buildings = buildings;
	}
	
	
	

}
