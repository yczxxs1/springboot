package com.kaituo.communitypolicing.business.domain;

import java.util.Date;

public class Person {

	private String personId;

	private String personName;

	private String personNation;

	private String personSex;

	private String personHeight;

	private String personResidenceAddress;

	private String personCurrentAddress;

	private String personCertificateType;

	private String personCertificateNumber;

	private String personRelationship;

	private String personType;

	private String personIskey;

	private String personServiceArea;

	private String personPhoneNumber;

	private Date personCreateDate;
	
	private String personAvatar;
	
	

	public String getPersonAvatar() {
		return personAvatar;
	}

	public void setPersonAvatar(String personAvatar) {
		this.personAvatar = personAvatar;
	}

	public String getPersonServiceArea() {
		return personServiceArea;
	}

	public void setPersonServiceArea(String personServiceArea) {
		this.personServiceArea = personServiceArea;
	}

	public String getPersonPhoneNumber() {
		return personPhoneNumber;
	}

	public void setPersonPhoneNumber(String personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
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

	public String getPersonSex() {
		return personSex;
	}

	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}

	public String getPersonNation() {
		return personNation;
	}

	public void setPersonNation(String personNation) {
		this.personNation = personNation;
	}

	public String getPersonHeight() {
		return personHeight;
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

	

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
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

	public String getPersonRelationship() {
		return personRelationship;
	}

	public void setPersonRelationship(String personRelationship) {
		this.personRelationship = personRelationship;
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
