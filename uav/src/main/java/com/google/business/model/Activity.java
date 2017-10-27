package com.google.business.model;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class Activity {

	private String id;

	private String activity;

	private String organizers;

	private String contractorId;

	private String contractorName;

	private String contractorPhone;

	private String areaId;

	private String address;
	
	private String remarks;

	private Date startTime;

	private Date endTime;

	private Date createDate;
	

	private String uavCount;
	@NotBlank(groups=MOBILELIST.class)
	private String review;

	private String areaName;
    @NotBlank(groups=MOBILELIST.class)
	private String userId;

	private List<SecurePhoto> securePhotos;

	private List<OrgPhoto> OrgPhotos;
	
	

	public String getUavCount() {
		return uavCount;
	}

	public List<SecurePhoto> getSecurePhotos() {
		return securePhotos;
	}

	public void setSecurePhotos(List<SecurePhoto> securePhotos) {
		this.securePhotos = securePhotos;
	}

	public List<OrgPhoto> getOrgPhotos() {
		return OrgPhotos;
	}

	public void setOrgPhotos(List<OrgPhoto> orgPhotos) {
		OrgPhotos = orgPhotos;
	}

	public void setUavCount(String uavCount) {
		this.uavCount = uavCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity == null ? null : activity.trim();
	}

	public String getOrganizers() {
		return organizers;
	}

	public void setOrganizers(String organizers) {
		this.organizers = organizers == null ? null : organizers.trim();
	}

	public String getContractorId() {
		return contractorId;
	}

	public void setContractorId(String contractorId) {
		this.contractorId = contractorId == null ? null : contractorId.trim();
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName == null ? null : contractorName.trim();
	}

	public String getContractorPhone() {
		return contractorPhone;
	}

	public void setContractorPhone(String contractorPhone) {
		this.contractorPhone = contractorPhone == null ? null : contractorPhone.trim();
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId == null ? null : areaId.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public interface MOBILELIST{};
	

}