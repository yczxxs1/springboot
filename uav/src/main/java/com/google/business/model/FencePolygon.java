package com.google.business.model;

public class FencePolygon {
	private String fpid;

	private Double latitude;

	private Double longitude;

	private Integer distance;

	private String fid;

	public String getFpid() {
		return fpid;
	}

	public void setFpid(String fpid) {
		this.fpid = fpid == null ? null : fpid.trim();
	}

	public Object getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid == null ? null : fid.trim();
	}
}