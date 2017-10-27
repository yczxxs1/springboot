package com.google.business.model;


public class FenceCircle {
    private String fid;

    private Double longitude;

    private Double latitude;

    private Integer radius;
    
   

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public Object getLongitude() {
        return longitude;
    }

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	
	
   
}