package com.kaituo.communitypolicing.business.domain;

public enum PersonType {

	PERMANENT("0"),
	FLOATING("1"),
	OVERSEA("2");
	
	private String code;

	private PersonType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
	
}
