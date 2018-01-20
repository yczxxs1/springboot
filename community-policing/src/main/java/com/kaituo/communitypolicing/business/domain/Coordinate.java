package com.kaituo.communitypolicing.business.domain;

public class Coordinate {

	private Double longitude;

	private Double latitude;

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	protected Coordinate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coordinate(Double longitude, Double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	
	
	
}
