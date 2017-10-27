package com.google.business.model;

public class UavModelEntity {
    /** null */
    private String id;

    /** null */
    private String modelName;

    /** null */
    private String productName;

    /** null */
    private String factoryId;

    /** null */
    private String productType;

    /** null */
    private String emptyWeight;

    /** null */
    private String maxTakeoffWeight;

    /** null */
    private String productPhotoUrl;
   /* 大图*/
    private String productBigPhotoUrl;

    /**
     *
     * 获取  null
     *
     * @return  id
     */
    public String getId() {
        return id;
    }

    public String getProductBigPhotoUrl() {
		return productBigPhotoUrl;
	}

	public void setProductBigPhotoUrl(String productBigPhotoUrl) {
		this.productBigPhotoUrl = productBigPhotoUrl;
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
     * @return  modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *
     * 设置  null
     *
     * @param modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
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
     * @return  productPhotoUrl
     */
    public String getProductPhotoUrl() {
        return productPhotoUrl;
    }

    /**
     *
     * 设置  null
     *
     * @param productPhotoUrl
     */
    public void setProductPhotoUrl(String productPhotoUrl) {
        this.productPhotoUrl = productPhotoUrl == null ? null : productPhotoUrl.trim();
    }
}