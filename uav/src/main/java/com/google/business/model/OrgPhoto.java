package com.google.business.model;

import java.util.Date;

public class OrgPhoto {
	private String id;

	private String actId;

	private String url;

	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId == null ? null : actId.trim();
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

	public OrgPhoto(String actId, String url, Date createDate) {
		super();
		this.actId = actId;
		this.url = url;
		this.createDate = createDate;
	}

	public OrgPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}

}