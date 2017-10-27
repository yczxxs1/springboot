package com.google.business.model;

import java.util.Date;

public class LicensePhotoEntity {
    /** null */
    private String id;

    /** null */
    private String licenseId;

    /** null */
    private String photoUrl;

    /** null */
    private String userId;

    /** null */
    private Date createDate;
    
    
    

    public LicensePhotoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LicensePhotoEntity(String licenseId, String photoUrl, String userId, Date createDate) {
		super();
		this.licenseId = licenseId;
		this.photoUrl = photoUrl;
		this.userId = userId;
		this.createDate = createDate;
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
     * @return  licenseId
     */
    public String getLicenseId() {
        return licenseId;
    }

    /**
     *
     * 设置  null
     *
     * @param licenseId
     */
    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId == null ? null : licenseId.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  photoUrl
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     *
     * 设置  null
     *
     * @param photoUrl
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
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
     * @return  createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *
     * 设置  null
     *
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}