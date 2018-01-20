package com.kaituo.communitypolicing.business.domain;

public enum PersonIsKey {
	key("1"),
	notKey("0");
	
	private String code;

	private PersonIsKey(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

	
}
