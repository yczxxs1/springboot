package com.google.business.dto;

import java.util.Date;

import com.google.business.util.poi.utils.ExcelResources;

public class LocationWebDTO{
	//姓名
	private String nikeName;

	//地点
	private String location;
	
	//时间
	private Date happenTime;

	//经度
	private Double longitude;

	//纬度
	private Double latitude;

	
	 public LocationWebDTO(String nikeName, String location, Date happenTime, Double longitude, 
			 Double latitude) {
	        this.nikeName = nikeName;
	        this.location = location;
	        this.happenTime = happenTime;
	        this.longitude = longitude;
	        this.latitude = latitude;
	    }
	    
	    public LocationWebDTO() {}
	    
	    @Override
	    public String toString() {
	        return "LocationWebDTO{" +
	                "nikeName='" + nikeName + '\'' +
	                ", location='" + location + '\'' +
	                ", happenTime='" + happenTime + '\'' +
	                ", longitude=" + longitude +'\'' +
	                ", latitude=" + latitude +
	                '}';
	    }
	    
	@ExcelResources(title="姓名",order=1)
	public String getNikeName() {
		return nikeName;
	}

	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}

	@ExcelResources(title="地点",order=2)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@ExcelResources(title="时间",order=3)
	public Date getHappenTime() {
		return happenTime;
	}

	public void setHappenTime(Date happenTime) {
		this.happenTime = happenTime;
	}

	@ExcelResources(title="经度",order=4)
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@ExcelResources(title="纬度",order=5)
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


}