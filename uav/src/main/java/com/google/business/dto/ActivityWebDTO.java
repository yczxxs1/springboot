package com.google.business.dto;

import com.google.business.util.poi.utils.ExcelResources;

public class ActivityWebDTO{
	//主办方
	private String organizers;

	//承办人
	private String contractorName;

	//承办人号码
	private String contractorPhone;

	//举办区域
    private String areaName;

	//地址
	private String address;

	//审核
	private String review;
	
	 public ActivityWebDTO(String organizers, String contractorName, String contractorPhone, String areaName, 
			 String address,String review) {
	        this.organizers = organizers;
	        this.contractorName = contractorName;
	        this.contractorPhone = contractorPhone;
	        this.areaName = areaName;
	        this.address = address;
	        this.review = review;
	    }
	    
	    public ActivityWebDTO() {}
	    
	    @Override
	    public String toString() {
	        return "ActivityWebDTO{" +
	                "organizers='" + organizers + '\'' +
	                ", contractorName='" + contractorName + '\'' +
	                ", contractorPhone='" + contractorPhone + '\'' +
	                ", areaName='" + areaName + '\'' +
	                ", review=" + review +'\'' +
	                ", address=" + address +
	                '}';
	    }
	
	@ExcelResources(title="举办方",order=1)
	public String getOrganizers() {
		return organizers;
	}

	public void setOrganizers(String organizers) {
		this.organizers = organizers;
	}
	
	@ExcelResources(title="承办人",order=2)
	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	
	@ExcelResources(title="承办联系方式",order=3)
	public String getContractorPhone() {
		return contractorPhone;
	}

	public void setContractorPhone(String contractorPhone) {
		this.contractorPhone = contractorPhone;
	}

	@ExcelResources(title="承办区域",order=4)
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@ExcelResources(title="承办地址",order=5)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ExcelResources(title="审核",order=6)
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}



}