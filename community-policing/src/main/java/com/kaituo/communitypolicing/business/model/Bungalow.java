package com.kaituo.communitypolicing.business.model;

public class Bungalow {
    private Double houseArea;

    private String housePurpose;

    private String houseType;

    private String houseHolder;

    private String buildingId;

    private String bungalowImgUrl;

    public Double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Double houseArea) {
        this.houseArea = houseArea;
    }

    public String getHousePurpose() {
        return housePurpose;
    }

    public void setHousePurpose(String housePurpose) {
        this.housePurpose = housePurpose == null ? null : housePurpose.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getHouseHolder() {
        return houseHolder;
    }

    public void setHouseHolder(String houseHolder) {
        this.houseHolder = houseHolder == null ? null : houseHolder.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getBungalowImgUrl() {
        return bungalowImgUrl;
    }

    public void setBungalowImgUrl(String bungalowImgUrl) {
        this.bungalowImgUrl = bungalowImgUrl == null ? null : bungalowImgUrl.trim();
    }
}