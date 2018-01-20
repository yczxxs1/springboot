package com.kaituo.communitypolicing.business.domain;

public enum PersonSex {
	MAN("1","男"),
	WOMAN("2","女");
	
	private String code;
	
	private String value;

	private PersonSex(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	


}
