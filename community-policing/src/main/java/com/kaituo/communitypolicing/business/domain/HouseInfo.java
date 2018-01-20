package com.kaituo.communitypolicing.business.domain;

public class HouseInfo {
	
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

	public HouseInfo(String houseType, Double houseArea, String houseHolder, String housePurpose) {
		super();
		this.houseType = houseType;
		this.houseArea = houseArea;
		this.houseHolder = houseHolder;
		this.housePurpose = housePurpose;
	}

	protected HouseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	

}
