package com.kaituo.communitypolicing.business.vo;

import java.util.List;

public class TallBuildingVo {
	
	private String buildingId;

	private String buildingName;

	private String buildingType;
	
	private List<UnitBriefVo> units;

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

	public List<UnitBriefVo> getUnits() {
		return units;
	}

	public void setUnits(List<UnitBriefVo> units) {
		this.units = units;
	}
	
	
	

}
