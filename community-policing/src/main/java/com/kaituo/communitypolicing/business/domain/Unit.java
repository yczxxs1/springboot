package com.kaituo.communitypolicing.business.domain;

import java.util.List;

public class Unit {

	private String unitId;
	
	private String unitName;
	
	private List<Floor> floors;
	


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

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}


	
	
	
	
	
	

}
