package com.google.business.model;

import java.util.Date;

import java.util.List;


public class LicenseEntity {
    /** null */
    private String id;

    /** null */
    private String userId;

    /** null */
    private String licenseTypeId;

    /** null */
    private String licenseTypeName;

    /** null */
    private String issuingAuthority;

    /** null */
    private String licenseNumber;

    /** null */
    private Date issuingDate;

    private String areaId;
    
    private String areaName;
    
    /** null */
    private Date validDate;

    private String nikeName;
    
    private String reviewRemark;
    
    private String reviewReason;
    
    
    
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getReviewReason() {
		return reviewReason;
	}

	public void setReviewReason(String reviewReason) {
		this.reviewReason = reviewReason;
	}

	public String getReviewRemark() {
		return reviewRemark;
	}

	public void setReviewRemark(String reviewRemark) {
		this.reviewRemark = reviewRemark;
	}

	public String getNikeName() {
		return nikeName;
	}

	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}

	/** null */
    private String licenseLevel;

    private String photoUrl;
    
    private List<LicensePhotoEntity> LicensePhotoList;
    
    private String licenseStatus;
    private String  review;
    
    private boolean Expired;


	public boolean isExpired() {
		return Expired;
	}

	public void setExpired(boolean expired) {
		Expired = expired;
	}

	public String getLicenseStatus() {
		return licenseStatus;
	}


	public void setLicenseStatus(String licenseStatus) {
		this.licenseStatus = licenseStatus;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public List<LicensePhotoEntity> getLicensePhotoList() {
		return LicensePhotoList;
	}

	public void setLicensePhotoList(List<LicensePhotoEntity> licensePhotoList) {
		LicensePhotoList = licensePhotoList;
	}

	/**
     *
     * 获取  null
     *
     * @return  id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * 设置  null
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * 设置  null
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  licenseTypeId
     */
    public String getLicenseTypeId() {
        return licenseTypeId;
    }

    /**
     *
     * 设置  null
     *
     * @param licenseTypeId
     */
    public void setLicenseTypeId(String licenseTypeId) {
        this.licenseTypeId = licenseTypeId == null ? null : licenseTypeId.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  licenseTypeName
     */
    public String getLicenseTypeName() {
        return licenseTypeName;
    }

    /**
     *
     * 设置  null
     *
     * @param licenseTypeName
     */
    public void setLicenseTypeName(String licenseTypeName) {
        this.licenseTypeName = licenseTypeName == null ? null : licenseTypeName.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  issuingAuthority
     */
    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    /**
     *
     * 设置  null
     *
     * @param issuingAuthority
     */
    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority == null ? null : issuingAuthority.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  licenseNumber
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     *
     * 设置  null
     *
     * @param licenseNumber
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  issuingDate
     */
    public Date getIssuingDate() {
        return issuingDate;
    }

    /**
     *
     * 设置  null
     *
     * @param issuingDate
     */
    public void setIssuingDate(Date issuingDate) {
        this.issuingDate = issuingDate;
    }

    /**
     *
     * 获取  null
     *
     * @return  validDate
     */
    public Date getValidDate() {
        return validDate;
    }

    /**
     *
     * 设置  null
     *
     * @param validDate
     */
    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    /**
     *
     * 获取  null
     *
     * @return  licenseLevel
     */
    public String getLicenseLevel() {
        return licenseLevel;
    }

    /**
     *
     * 设置  null
     *
     * @param licenseLevel
     */
    public void setLicenseLevel(String licenseLevel) {
        this.licenseLevel = licenseLevel == null ? null : licenseLevel.trim();
    }
}