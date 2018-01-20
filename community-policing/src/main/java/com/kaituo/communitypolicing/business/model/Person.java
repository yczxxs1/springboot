package com.kaituo.communitypolicing.business.model;

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

    private String personLxfs;

    private Date personCreateDate;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPersonNation() {
        return personNation;
    }

    public void setPersonNation(String personNation) {
        this.personNation = personNation == null ? null : personNation.trim();
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex == null ? null : personSex.trim();
    }

    public String getPersonHeight() {
        return personHeight;
    }

    public void setPersonHeight(String personHeight) {
        this.personHeight = personHeight == null ? null : personHeight.trim();
    }

    public String getPersonResidenceAddress() {
        return personResidenceAddress;
    }

    public void setPersonResidenceAddress(String personResidenceAddress) {
        this.personResidenceAddress = personResidenceAddress == null ? null : personResidenceAddress.trim();
    }

    public String getPersonCurrentAddress() {
        return personCurrentAddress;
    }

    public void setPersonCurrentAddress(String personCurrentAddress) {
        this.personCurrentAddress = personCurrentAddress == null ? null : personCurrentAddress.trim();
    }

    public String getPersonCertificateType() {
        return personCertificateType;
    }

    public void setPersonCertificateType(String personCertificateType) {
        this.personCertificateType = personCertificateType == null ? null : personCertificateType.trim();
    }

    public String getPersonCertificateNumber() {
        return personCertificateNumber;
    }

    public void setPersonCertificateNumber(String personCertificateNumber) {
        this.personCertificateNumber = personCertificateNumber == null ? null : personCertificateNumber.trim();
    }

    public String getPersonRelationship() {
        return personRelationship;
    }

    public void setPersonRelationship(String personRelationship) {
        this.personRelationship = personRelationship == null ? null : personRelationship.trim();
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType == null ? null : personType.trim();
    }

    public String getPersonIskey() {
        return personIskey;
    }

    public void setPersonIskey(String personIskey) {
        this.personIskey = personIskey == null ? null : personIskey.trim();
    }

    public String getPersonServiceArea() {
        return personServiceArea;
    }

    public void setPersonServiceArea(String personServiceArea) {
        this.personServiceArea = personServiceArea == null ? null : personServiceArea.trim();
    }

    public String getPersonLxfs() {
        return personLxfs;
    }

    public void setPersonLxfs(String personLxfs) {
        this.personLxfs = personLxfs == null ? null : personLxfs.trim();
    }

    public Date getPersonCreateDate() {
        return personCreateDate;
    }

    public void setPersonCreateDate(Date personCreateDate) {
        this.personCreateDate = personCreateDate;
    }
}