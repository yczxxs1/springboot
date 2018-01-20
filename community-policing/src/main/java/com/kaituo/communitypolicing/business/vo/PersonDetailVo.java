package com.kaituo.communitypolicing.business.vo;

import java.util.Date;

import com.kaituo.communitypolicing.business.domain.PersonSex;
import com.kaituo.communitypolicing.business.domain.PersonType;

import io.swagger.annotations.ApiModelProperty;

public class PersonDetailVo {

	private static final String CM = "cm";

	private String personId;
	@ApiModelProperty("姓名")
	private String personName;
	@ApiModelProperty("头像url")
	private String personAvatar;
	@ApiModelProperty("民族")
	private String personNation;
	@ApiModelProperty("性别")
	private String personSex;
	@ApiModelProperty("人口类型 0:常住 1:流动2 :海外")
	private String personType;
	@ApiModelProperty("是否为重点人口 0是 1否")
	private String personIskey;
	@ApiModelProperty("证件类型")
	private String personCertificateType;
	@ApiModelProperty("证件号码")
	private String personCertificateNumber;
	@ApiModelProperty("身高")
	private String personHeight;
	@ApiModelProperty("户籍地址")
	private String personResidenceAddress;
	@ApiModelProperty("现居地址")
	private String personCurrentAddress;
	@ApiModelProperty("登记时间")
	private Date personCreateDate;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonAvatar() {
		return personAvatar;
	}

	public void setPersonAvatar(String personAvatar) {
		this.personAvatar = personAvatar;
	}

	public String getPersonNation() {
		return personNation;
	}

	public void setPersonNation(String personNation) {
		this.personNation = personNation;
	}

	public String getPersonSex() {
		if (PersonSex.MAN.getCode().equals(this.personSex)) {
			return PersonSex.MAN.getValue();
		} else {
			return PersonSex.WOMAN.getValue();
		}
	}

	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}

	public String getPersonType() {
		if (this.personType.equals(PersonType.PERMANENT.getCode())) {
			return "常住";
		} else if (this.personType.equals(PersonType.FLOATING.getCode())) {
			return "流动";
		} else if (this.personType.equals(PersonType.OVERSEA.getCode())) {
			return "境外";
		} else {
			return personType;
		}

	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getPersonIskey() {

		return personIskey;

	}

	public void setPersonIskey(String personIskey) {
		this.personIskey = personIskey;
	}

	public String getPersonCertificateType() {
		return personCertificateType;
	}

	public void setPersonCertificateType(String personCertificateType) {
		this.personCertificateType = personCertificateType;
	}

	public String getPersonCertificateNumber() {
		return personCertificateNumber;
	}

	public void setPersonCertificateNumber(String personCertificateNumber) {
		this.personCertificateNumber = personCertificateNumber;
	}

	public String getPersonHeight() {
		return personHeight + CM;
	}

	public void setPersonHeight(String personHeight) {
		this.personHeight = personHeight;
	}

	public String getPersonResidenceAddress() {
		return personResidenceAddress;
	}

	public void setPersonResidenceAddress(String personResidenceAddress) {
		this.personResidenceAddress = personResidenceAddress;
	}

	public String getPersonCurrentAddress() {
		return personCurrentAddress;
	}

	public void setPersonCurrentAddress(String personCurrentAddress) {
		this.personCurrentAddress = personCurrentAddress;
	}

	public Date getPersonCreateDate() {
		return personCreateDate;
	}

	public void setPersonCreateDate(Date personCreateDate) {
		this.personCreateDate = personCreateDate;
	}

}
