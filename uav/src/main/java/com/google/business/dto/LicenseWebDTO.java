package com.google.business.dto;

import com.google.business.util.poi.utils.ExcelResources;

public class LicenseWebDTO{
	
	//姓名
    private String nikeName;
    
    //证书类型名称
    private String licenseTypeName;

    //发证机关
    private String issuingAuthority;

    //证书级别
    private String licenseLevel;

    //是否审核
    private String  review;

    //区域
    private String areaName;

    public LicenseWebDTO(String nikeName, String licenseTypeName, String issuingAuthority, String licenseLevel, 
    		String review,String  areaName) {
	        this.nikeName = nikeName;
	        this.licenseTypeName = licenseTypeName;
	        this.issuingAuthority = issuingAuthority;
	        this.licenseLevel = licenseLevel;
	        this.review = review;
	        this.areaName = areaName;
	    }
	    
	    public LicenseWebDTO() {}
	    
	    @Override
	    public String toString() {
	        return "LicenseWebDTO{" +
	                "nikeName='" + nikeName + '\'' +
	                ", licenseTypeName='" + licenseTypeName + '\'' +
	                ", issuingAuthority='" + issuingAuthority + '\'' +
	                ", licenseLevel=" + licenseLevel +'\'' +
	                ", review=" + review +'\'' +
	                ", areaName=" + areaName +
	                '}';
	    }
	    
	@ExcelResources(title="姓名",order=1)
	public String getNikeName() {
		return nikeName;
	}

	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}

	@ExcelResources(title="证书类型",order=2)
	public String getLicenseTypeName() {
		return licenseTypeName;
	}

	public void setLicenseTypeName(String licenseTypeName) {
		this.licenseTypeName = licenseTypeName;
	}

	@ExcelResources(title="发证机构",order=3)
	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}

	@ExcelResources(title="证书级别",order=4)
	public String getLicenseLevel() {
		return licenseLevel;
	}

	public void setLicenseLevel(String licenseLevel) {
		this.licenseLevel = licenseLevel;
	}

	@ExcelResources(title="审核",order=5)
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@ExcelResources(title="区域",order=6)
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	
}