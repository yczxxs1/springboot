package com.kaituo.communitypolicing.business.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Bungalow extends Building {

	private HouseInfo houseInfo;

	@JsonIgnore
	private String bungalowImgUrl;

	private String[] imgs = new String[0];

	private List<String> personIds;

	public HouseInfo getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}

	public String getBungalowImgUrl() {
		return bungalowImgUrl;
	}

	public void setBungalowImgUrl(String bungalowImgUrl) {
		this.bungalowImgUrl = bungalowImgUrl;
		this.imgs = bungalowImgUrl.split(",");

	}

	public List<String> getPersonIds() {
		return personIds;
	}

	public void setPersonIds(List<String> personIds) {
		this.personIds = personIds;
	}

	public String[] getImgs() {
		return imgs;
	}

	public void setImgs(String[] imgs) {
		this.imgs = imgs;
	}

	protected Bungalow() {
		super();
		// TODO Auto-generated constructor stub
		this.imgs = new String[0];
	}

}
