package com.google.business.model;

import io.swagger.annotations.ApiParam;

public class Person {
	private String id;
	@ApiParam(value = "实际居住地址")
	private String residenceAddress;
	@ApiParam("户籍地址")
	private String censusRegisterAddress;
	@ApiParam("邮件")
	private String email;
	@ApiParam("用户")
	private String userId;
	@ApiParam("省")
	private Province province;
	@ApiParam("市")
	private City city;
	@ApiParam("区")
	private Area area;

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress == null ? null : residenceAddress.trim();
	}

	public String getCensusRegisterAddress() {
		return censusRegisterAddress;
	}

	public void setCensusRegisterAddress(String censusRegisterAddress) {
		this.censusRegisterAddress = censusRegisterAddress == null ? null : censusRegisterAddress.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
}