package com.google.business.model;

import java.util.Date;

import java.util.List;

public class UavEntity {
    /** null */
    private String id;

    /** null */
    private String code;

    /** null */
    private String snNumber;

    /** null */
    private String factoryId;

    /** null */
    private String modelId;

    /** null */
    private String productName;

    /** null */
    private String productType;
    
    private String productTypeName;

    /** null */
    private String emptyWeight;

    /** null */
    private String maxTakeoffWeight;

    /** null */
    private String purpose;

    /** null */
    private Date regDate;

    /** null */
    private Date validDate;

    /** null */
    private String belongTo;
    
    private String belongTo2;//条件字段，非返回字段


	/** null */
    private String belongId;

    /** null */
    private String status;
    
    private String status2;//条件字段，非返回字段
    
    private String review;
    
    private String review2;//条件字段，非返回字段

    private String photoUrl;
    
    private List<UavPhotoEntity> uavPhotoList;
    
    private String factoryName;
    private String modelName;
    
    private String reviewReason;
    
    private String reviewRemark;
    
   /* private String belongName;
    private String userMobile;*/
    private String purposeName;
    
    private User user;
    
    private Companys company;
    
    private Police police;

	public Police getPolice() {
		return police;
	}


	public void setPolice(Police police) {
		this.police = police;
	}

	//下面三个是新增的字段
    private String belongType;
    
    private String madeByself;
    
    private String areaId;
    
    private String belongTypeName;
    
    private String areaName;
    
    
    public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getBelongTypeName() {
		return belongTypeName;
	}


	public void setBelongTypeName(String belongTypeName) {
		this.belongTypeName = belongTypeName;
	}


	/**
     * 迁移之后
     * @return
     */
    //private CompanyEntity ce;
    //private UserinfoEntity ue;
    

    
    
	public String getReview2() {
		return review2;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Companys getCompany() {
		return company;
	}


	public void setCompany(Companys company) {
		this.company = company;
	}


	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

	public String getMadeByself() {
		return madeByself;
	}

	public void setMadeByself(String madeByself) {
		this.madeByself = madeByself;
	}

	public void setReview2(String review2) {
		this.review2 = review2;
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

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getBelongTo2() {
		return belongTo2;
	}

	public void setBelongTo2(String belongTo2) {
		this.belongTo2 = belongTo2;
	}
    
	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	/*public UserinfoEntity getUe() {
		return ue;
	}

	public void setUe(UserinfoEntity ue) {
		this.ue = ue;
	}

	public CompanyEntity getCe() {
		return ce;
	}

	public void setCe(CompanyEntity ce) {
		this.ce = ce;
	}*/

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getPurposeName() {
		return purposeName;
	}

	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public List<UavPhotoEntity> getUavPhotoList() {
		return uavPhotoList;
	}

	public void setUavPhotoList(List<UavPhotoEntity> uavPhotoList) {
		this.uavPhotoList = uavPhotoList;
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
     * @return  code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * 设置  null
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  snNumber
     */
    public String getSnNumber() {
        return snNumber;
    }

    /**
     *
     * 设置  null
     *
     * @param snNumber
     */
    public void setSnNumber(String snNumber) {
        this.snNumber = snNumber == null ? null : snNumber.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  factoryId
     */
    public String getFactoryId() {
        return factoryId;
    }

    /**
     *
     * 设置  null
     *
     * @param factoryId
     */
    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId == null ? null : factoryId.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     *
     * 设置  null
     *
     * @param modelId
     */
    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * 设置  null
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     *
     * 设置  null
     *
     * @param productType
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  emptyWeight
     */
    public String getEmptyWeight() {
        return emptyWeight;
    }

    /**
     *
     * 设置  null
     *
     * @param emptyWeight
     */
    public void setEmptyWeight(String emptyWeight) {
        this.emptyWeight = emptyWeight == null ? null : emptyWeight.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  maxTakeoffWeight
     */
    public String getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    /**
     *
     * 设置  null
     *
     * @param maxTakeoffWeight
     */
    public void setMaxTakeoffWeight(String maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight == null ? null : maxTakeoffWeight.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     *
     * 设置  null
     *
     * @param purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  regDate
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     *
     * 设置  null
     *
     * @param regDate
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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
     * @return  belongTo
     */
    public String getBelongTo() {
        return belongTo;
    }

    /**
     *
     * 设置  null
     *
     * @param belongTo
     */
    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo == null ? null : belongTo.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  belongId
     */
    public String getBelongId() {
        return belongId;
    }

    /**
     *
     * 设置  null
     *
     * @param belongId
     */
    public void setBelongId(String belongId) {
        this.belongId = belongId == null ? null : belongId.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * 设置  null
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


	public String getAreaId() {
		return areaId;
	}


	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}