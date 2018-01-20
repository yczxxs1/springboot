package com.kaituo.communitypolicing.business.vo;

import java.util.Date;

import com.kaituo.communitypolicing.business.domain.PersonSex;
import com.kaituo.communitypolicing.business.domain.PersonType;

import io.swagger.annotations.ApiModelProperty;

public class PersonListVo {
	private String personId;
	@ApiModelProperty("姓名")
	private String personName;
	@ApiModelProperty("头像url")
	private String personAvatar;
	@ApiModelProperty("民族")
	private String personNation;
	@ApiModelProperty("人员关系")
	private String personRelationship;
	@ApiModelProperty("性别")
	private String personSex;
	@ApiModelProperty("人口类型 0:常住 1:流动2 :海外")
	private String personType;
	@ApiModelProperty("是否为重点人口 0是 1否")
	private String personIskey;
	@ApiModelProperty("登记时间")
	private Date personCreateDate;

	public String getPersonRelationship() {
		return personRelationship;
	}

	public void setPersonRelationship(String personRelationship) {
		this.personRelationship = personRelationship;
	}

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

	public Date getPersonCreateDate() {
		return personCreateDate;
	}

	public void setPersonCreateDate(Date personCreateDate) {
		this.personCreateDate = personCreateDate;
	}

}
