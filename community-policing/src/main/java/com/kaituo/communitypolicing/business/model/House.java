package com.kaituo.communitypolicing.business.model;

public class House {
    private String houseId;

    private String houseName;

    private Double houseArea;

    private String housePurpose;

    private String houseType;

    private String houseHolder;

    private String floorId;

    private String houseImgUrl;

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName == null ? null : houseName.trim();
    }

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

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId == null ? null : floorId.trim();
    }

    public String getHouseImgUrl() {
        return houseImgUrl;
    }

    public void setHouseImgUrl(String houseImgUrl) {
        this.houseImgUrl = houseImgUrl == null ? null : houseImgUrl.trim();
    }
}