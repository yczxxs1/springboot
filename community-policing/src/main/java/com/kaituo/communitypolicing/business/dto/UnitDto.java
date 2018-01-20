package com.kaituo.communitypolicing.business.dto;

import java.util.List;

public class UnitDto {

	private String unitId;

	private String unitName;
	
	private List<FloorDto> floors;
	
	

	public List<FloorDto> getFloors() {
		return floors;
	}

	public void setFloors(List<FloorDto> floors) {
		this.floors = floors;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	

}
