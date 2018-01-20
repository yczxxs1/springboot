package com.kaituo.communitypolicing.business.model;

public class Building {
    private String buildingId;

    private String buildingName;

    private String buildingType;

    private String buildingSjid;

    private String buildingZb;

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType == null ? null : buildingType.trim();
    }

    public String getBuildingSjid() {
        return buildingSjid;
    }

    public void setBuildingSjid(String buildingSjid) {
        this.buildingSjid = buildingSjid == null ? null : buildingSjid.trim();
    }

    public String getBuildingZb() {
        return buildingZb;
    }

    public void setBuildingZb(String buildingZb) {
        this.buildingZb = buildingZb == null ? null : buildingZb.trim();
    }
}