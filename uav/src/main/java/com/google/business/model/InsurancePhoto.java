package com.google.business.model;

import java.util.Date;

public class InsurancePhoto {
    private String id;

    private String actUavId;

    private String url;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getActUavId() {
        return actUavId;
    }

    public void setActUavId(String actUavId) {
        this.actUavId = actUavId == null ? null : actUavId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public InsurancePhoto(String actUavId, String url, Date createDate) {
		super();
		this.actUavId = actUavId;
		this.url = url;
		this.createDate = createDate;
	}

	public InsurancePhoto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}