package com.google.business.model;

public class Area {
    private String areaId;

    private String areaName;

    private String areaFatherId;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaFatherId() {
        return areaFatherId;
    }

    public void setAreaFatherId(String areaFatherId) {
        this.areaFatherId = areaFatherId == null ? null : areaFatherId.trim();
    }
}