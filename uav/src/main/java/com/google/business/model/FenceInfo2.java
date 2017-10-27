package com.google.business.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FenceInfo2 {
	
	private String fid;

    private Integer fenceid;

    private String monitedPerson;

    private String fenceName;

    private String fenceStart;

    private String fenceEnd;

    private Integer fenceHeight;

    private String fenceType;
    
    private String fenceTypeName;
    
    private Double longitude;
    
    private Double latitude;
    
    private String status;
    
    private Double distance;
    
    
    

    public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getFenceTypeName() {
		return fenceTypeName;
	}

	public void setFenceTypeName(String fenceTypeName) {
		this.fenceTypeName = fenceTypeName;
	}

	
	public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    
    public Integer getFenceid() {
		return fenceid;
	}

	public void setFenceid(Integer fenceid) {
		this.fenceid = fenceid;
	}

	public String getMonitedPerson() {
        return monitedPerson;
    }

    public void setMonitedPerson(String monitedPerson) {
        this.monitedPerson = monitedPerson == null ? null : monitedPerson.trim();
    }

    public String getFenceName() {
        return fenceName;
    }

    public void setFenceName(String fenceName) {
        this.fenceName = fenceName == null ? null : fenceName.trim();
    }

    public Date getFenceStart() throws Exception {
    	SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");//小写的mm表示的是分钟  
    	Date date=sdf.parse(fenceStart);  
        return date;
    }

    public void setFenceStart(String fenceStart) {
        this.fenceStart = fenceStart == null ? null : fenceStart.trim();
    }

    public Date getFenceEnd() throws Exception {
    	SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");//小写的mm表示的是分钟  
    	Date date=sdf.parse(fenceEnd);  
        return date;
    }

    public void setFenceEnd(String fenceEnd) {
        this.fenceEnd = fenceEnd == null ? null : fenceEnd.trim();
    }

   

    public Integer getFenceHeight() {
		return fenceHeight;
	}

	public void setFenceHeight(Integer fenceHeight) {
		this.fenceHeight = fenceHeight;
	}

	public String getFenceType() {
        return fenceType;
    }

    public void setFenceType(String fenceType) {
        this.fenceType = fenceType == null ? null : fenceType.trim();
    }

}
