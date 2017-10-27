package com.google.business.model;

import java.util.Date;

public class LocationInfoEntity {
	private String id;

	private String location;

	private Double longitude;

	private Double latitude;

	private String locationImg;

	private Date happenTime;

	@SuppressWarnings("unused")
	private Date currentTime;

	private String userId;
	
	/**
	 * 迁移后
	 * @return
	 */
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getHappenTime() {
		return happenTime;
	}

	public void setHappenTime(Date happenTime) {
		this.happenTime = happenTime;
	}

	public Date getCurrentTime() {
		return new Date();
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location == null ? null : location.trim();
	}

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

	public String getLocationImg() {
		return locationImg;
	}

	public void setLocationImg(String locationImg) {
		this.locationImg = locationImg == null ? null : locationImg.trim();
	}

	public LocationInfoEntity(Double longitude, Double latitude, Date happenTime, String userId) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.happenTime = happenTime;
		this.userId = userId;
	}

	public LocationInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}