package com.kaituo.communitypolicing.business.vo;

import java.util.List;

public class FloorVo {
	
	private String floorId;

	private String floorName;
	
	private List<HouseBriefVo> houses;

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public List<HouseBriefVo> getHouses() {
		return houses;
	}

	public void setHouses(List<HouseBriefVo> houses) {
		this.houses = houses;
	}
	
	

}
