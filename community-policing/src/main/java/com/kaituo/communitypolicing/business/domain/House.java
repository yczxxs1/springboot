package com.kaituo.communitypolicing.business.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class House {

	private String houseId;

	private String houseName;

	private HousePopulationInfo housePopulationInfo;

	private HouseInfo houseInfo;

	private List<String> personIds;

	@JsonIgnore
	private String houseImgUrl;

	private String[] imgs ;

	public String getHouseImgUrl() {
		return houseImgUrl;
	}

	public void setHouseImgUrl(String houseImgUrl) {
		this.houseImgUrl = houseImgUrl;
		this.imgs = houseImgUrl.split(",");

	}

	public String[] getImgs() {
		return imgs;
	}

	public void setImgs(String[] imgs) {
		this.imgs = imgs;
	}

	public List<String> getPersonIds() {
		return personIds;
	}

	public void setPersonIds(List<String> personIds) {
		this.personIds = personIds;
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

	public HousePopulationInfo getHousePopulationInfo() {
		return housePopulationInfo;
	}

	public void setHousePopulationInfo(HousePopulationInfo housePopulationInfo) {
		this.housePopulationInfo = housePopulationInfo;
	}

	public HouseInfo getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}

	protected House() {
		super();
		// TODO Auto-generated constructor stub
		this.imgs= new String[0];
		
	}

	
	
}
