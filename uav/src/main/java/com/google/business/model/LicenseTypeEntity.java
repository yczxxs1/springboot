package com.google.business.model;

public class LicenseTypeEntity {
    /** null */
    private String licenseTypeId;

    /** null */
    private String licenseTypeName;

    /** null */
    private String issuingAuthority;

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
}