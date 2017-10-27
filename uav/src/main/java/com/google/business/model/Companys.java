package com.google.business.model;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiParam;

public class Companys {
    private String id;

    @ApiParam("单位名称")
    private String name;
    @ApiParam("证照类型0=统一社会信用代码1=组织机构代码")
    private String certType;
    @ApiParam("证照号码")
    private String certNumber;
    @ApiParam("法人")
    private String corporation;
    @ApiParam("单位地址")
    private String address;
    @ApiParam("单位邮箱")
    private String companyEmail;

    private Date createDate;
    @ApiParam("法人身份证号")
    private String corporationNumber;
    
    private String userId;
    
    private Province province;
    
    private City city;
    
    private Area area;
    
    private List<CompanyPhoto> companyPhotos;
    
    
    
    public List<CompanyPhoto> getCompanyPhotos() {
		return companyPhotos;
	}

	public void setCompanyPhotos(List<CompanyPhoto> companyPhotos) {
		this.companyPhotos = companyPhotos;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber == null ? null : certNumber.trim();
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation == null ? null : corporation.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail == null ? null : companyEmail.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCorporationNumber() {
        return corporationNumber;
    }

    public void setCorporationNumber(String corporationNumber) {
        this.corporationNumber = corporationNumber == null ? null : corporationNumber.trim();
    }
}