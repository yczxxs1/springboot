package com.kaituo.communitypolicing.business.dto;

import java.util.List;

public class BuildingDto {

	private String buildingId;

	private String buildingName;

	private String buildingType;
	
	private List<UnitDto> units;
	
	private String houseType;

	private Double houseArea;

	private String houseHolder;

	private String housePurpose;
	
	


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

	public List<UnitDto> getUnits() {
		return units;
	}

	public void setUnits(List<UnitDto> units) {
		this.units = units;
	}

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


}
