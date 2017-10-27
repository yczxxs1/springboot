package com.google.business.model;

import java.util.Date;

import io.swagger.annotations.ApiParam;

public class CompanyPhoto {
    private String id;

    private String companyId;
    @ApiParam("单位执照")
    private String certPhoto;

    private Date createDate;
    
    

    public CompanyPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyPhoto( String companyId, String certPhoto, Date createDate) {
		super();
		this.companyId = companyId;
		this.certPhoto = certPhoto;
		this.createDate = createDate;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCertPhoto() {
        return certPhoto;
    }

    public void setCertPhoto(String certPhoto) {
        this.certPhoto = certPhoto == null ? null : certPhoto.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}