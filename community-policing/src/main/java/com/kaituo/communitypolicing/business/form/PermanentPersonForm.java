package com.kaituo.communitypolicing.business.form;

import com.kaituo.communitypolicing.business.domain.PersonSex;

import io.swagger.annotations.ApiModelProperty;

public class PermanentPersonForm {

	@ApiModelProperty("姓名")
	private String personName;

	@ApiModelProperty("身份证")
	private String personCertificateNumber;

	@ApiModelProperty("性别")
	private String personSex;

	@ApiModelProperty("手机号码")
	private String personPhoneNumber;

	@ApiModelProperty("服务区域")
	private String personServiceArea;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonCertificateNumber() {
		return personCertificateNumber;
	}

	public void setPersonCertificateNumber(String personCertificateNumber) {
		this.personCertificateNumber = personCertificateNumber;
	}

	public String getPersonSex() {
		return personSex;
	}

	public void setPersonSex(String personSex) {
		
		if (personSex.equals(PersonSex.MAN.getValue())) {
			this.personSex = PersonSex.MAN.getCode();
		} else if (personSex.equals(PersonSex.WOMAN.getValue())) {
			this.personSex = PersonSex.WOMAN.getCode();
		} else {
			this.personSex = personSex;
		}
		
	
	}

	public String getPersonPhoneNumber() {
		return personPhoneNumber;
	}

	public void setPersonPhoneNumber(String personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
	}

	public String getPersonServiceArea() {
		return personServiceArea;
	}

	public void setPersonServiceArea(String personServiceArea) {
		this.personServiceArea = personServiceArea;
	}

}
