package com.google.business.dto;

import java.util.Date;

public class LocationDTO {
	
	private Date startTime;
	
	private Date endTime;	
	
	private String[] areaId;

	public String[] getAreaId() {
		return areaId;
	}

	public void setAreaId(String[] areaId) {
		this.areaId = areaId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	

}
