package com.kaituo.communitypolicing.business.vo;

import com.kaituo.communitypolicing.business.domain.HousePopulationInfo;

import io.swagger.annotations.ApiModelProperty;

public class HouseBriefVo {
	
	private String houseId;
	@ApiModelProperty("室名")
	private String houseName;
	
	private HousePopulationInfo housePopulationInfo;
	@ApiModelProperty("用途")
	private String housePurpose;

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public HousePopulationInfo getHousePopulationInfo() {
		return housePopulationInfo;
	}

	public void setHousePopulationInfo(HousePopulationInfo housePopulationInfo) {
		this.housePopulationInfo = housePopulationInfo;
	}

	public String getHousePurpose() {
		return housePurpose;
	}

	public void setHousePurpose(String housePurpose) {
		this.housePurpose = housePurpose;
	}

	
	
	

}
