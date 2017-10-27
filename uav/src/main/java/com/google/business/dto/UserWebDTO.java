package com.google.business.dto;

import com.google.business.util.poi.utils.ExcelResources;

public class UserWebDTO {

	//用户名
	private String name;

	//手机号码
	private String userMobile;

	//性别
	private String sex;

	//证件号
	private String certNumber;

	//姓名
	private String nikeName;

	//区域
	private String areaName;

	//地址
	private String residenceAddress;
	
	//邮箱
	private String email;

	
	 public UserWebDTO(String name, String userMobile, String sex, String certNumber, 
	    		String nikeName,String  areaName,String residenceAddress,String email) {
		        this.name = name;
		        this.userMobile = userMobile;
		        this.sex = sex;
		        this.certNumber = certNumber;
		        this.nikeName = nikeName;
		        this.areaName = areaName;
		        this.residenceAddress = residenceAddress;
		        this.email = email;
		    }
		    
		    public UserWebDTO() {}
		    
		    @Override
		    public String toString() {
		        return "UserWebDTO{" +
		                "name='" + name + '\'' +
		                ", userMobile='" + userMobile + '\'' +
		                ", sex='" + sex + '\'' +
		                ", certNumber=" + certNumber +'\'' +
		                ", nikeName=" + nikeName +'\'' +
		                ", areaName=" + areaName +'\'' +
		                ", residenceAddress=" + residenceAddress +'\'' +
		                ", email=" + email +
		                '}';
		    }
		    
	@ExcelResources(title="用户名",order=1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ExcelResources(title="联系电话",order=2)
	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	@ExcelResources(title="性别",order=3)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@ExcelResources(title="身份证号码",order=4)
	public String getCertNumber() {
		return certNumber;
	}

	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}

	@ExcelResources(title="姓名",order=5)
	public String getNikeName() {
		return nikeName;
	}

	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}

	@ExcelResources(title="区域",order=6)
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	@ExcelResources(title="详细地址",order=7)
	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	@ExcelResources(title="邮箱",order=8)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
