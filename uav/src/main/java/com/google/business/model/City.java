package com.google.business.model;

public class City {
    private String cityId;

    private String cityName;

    private String cityFatherId;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCityFatherId() {
        return cityFatherId;
    }

    public void setCityFatherId(String cityFatherId) {
        this.cityFatherId = cityFatherId == null ? null : cityFatherId.trim();
    }
}