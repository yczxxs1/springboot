package com.kaituo.communitypolicing.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("建筑物列表")
public class BuildingListVo {

	private String buildingId;
	@ApiModelProperty("建筑物名")
	private String buildingName;
	@ApiModelProperty("建筑物类型：0为无层户结构,1有层户结构")
	private String buildingType;

	@ApiModelProperty("距离")
	private Integer distance;

	
	

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	
	

}
