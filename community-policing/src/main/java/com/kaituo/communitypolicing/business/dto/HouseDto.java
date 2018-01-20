package com.kaituo.communitypolicing.business.dto;

import com.kaituo.communitypolicing.business.domain.HousePopulationInfo;

public class HouseDto {

	private String houseId;

	private String houseName;
	
	private String houseFullName;

	private HousePopulationInfo housePopulationInfo;

	private String houseType;

	private Double houseArea;

	private String houseHolder;

	private String housePurpose;

	private String[] imgs;
	
	
	

	public String getHouseFullName() {
		return houseFullName;
	}

	public void setHouseFullName(String houseFullName) {
		this.houseFullName = houseFullName;
	}

	public HousePopulationInfo getHousePopulationInfo() {
		return housePopulationInfo;
	}

	public void setHousePopulationInfo(HousePopulationInfo housePopulationInfo) {
		this.housePopulationInfo = housePopulationInfo;
	}

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

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public Double getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(Double houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseHolder() {
		return houseHolder;
	}

	public void setHouseHolder(String houseHolder) {
		this.houseHolder = houseHolder;
	}

	public String getHousePurpose() {
		return housePurpose;
	}

	public void setHousePurpose(String housePurpose) {
		this.housePurpose = housePurpose;
	}

	public String[] getImgs() {
		return imgs;
	}

	public void setImgs(String[] imgs) {
		this.imgs = imgs;
	}
	
	

}
