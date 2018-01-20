package com.kaituo.communitypolicing.business.dto;

import java.util.List;

public class FloorDto {

	private String floorId;

	private String floorName;

	private List<HouseDto> houses;

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

	public List<HouseDto> getHouses() {
		return houses;
	}

	public void setHouses(List<HouseDto> houses) {
		this.houses = houses;
	}

}
