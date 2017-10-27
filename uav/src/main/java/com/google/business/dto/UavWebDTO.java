package com.google.business.dto;

import com.google.business.util.poi.utils.ExcelResources;

public class UavWebDTO{
	
	//无人机SN编号
    private String snNumber;
    
    //厂商名称
    private String factoryName;

    //型号名称
    private String modelName;

    //归属类型
    private String belongType;

    //状态
    private String status;

    //审核
    private String review;
    
    //区域
    private String areaName;
    
    public UavWebDTO(String snNumber, String factoryName, String modelName, String belongType, String status,String review,String areaName) {
        this.snNumber = snNumber;
        this.factoryName = factoryName;
        this.modelName = modelName;
        this.belongType = belongType;
        this.status = status;
        this.review = review;
        this.areaName = areaName;
    }
    
    public UavWebDTO() {}
    
    @Override
    public String toString() {
        return "UavWebDTO{" +
                "snNumber='" + snNumber + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", belongType='" + belongType + '\'' +
                ", status=" + status +'\'' +
                ", review=" + review +'\'' +
                ", areaName=" + areaName +
                '}';
    }

    @ExcelResources(title="SN编号",order=1)
	public String getSnNumber() {
		return snNumber;
	}

	public void setSnNumber(String snNumber) {
		this.snNumber = snNumber;
	}

    @ExcelResources(title="生产厂商",order=2)
	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

    @ExcelResources(title="型号名称",order=3)
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
    @ExcelResources(title="归属类型",order=4)
	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

    @ExcelResources(title="状态 ",order=5)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    @ExcelResources(title="审核状态",order=6)
	public String getReview() {
		return review;
	}
    
	public void setReview(String review) {
		this.review = review;
	}

    @ExcelResources(title="区域",order=7)
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}



}