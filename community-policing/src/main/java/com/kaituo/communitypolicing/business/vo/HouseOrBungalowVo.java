package com.kaituo.communitypolicing.business.vo;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class HouseOrBungalowVo {

	@ApiModelProperty("平房名或室名Id")
	private String houseOrBungalowId;
	@ApiModelProperty("平房名或室名全称")
	private String houseFullNameOrBungalowName;
	@ApiModelProperty("户型")
	private String houseType;
	@ApiModelProperty("面积")
	private String houseArea;
	@ApiModelProperty("户主")
	private String houseHolder;
	@ApiModelProperty("用途")
	private String housePurpose;
	@ApiModelProperty("图片数组")
	private String[] imgs;

	private List<PersonListVo> persons;
	
	
	

	public String[] getImgs() {
		return imgs;
	}

	public void setImgs(String[] imgs) {
		this.imgs = imgs;
	}

	public String getHouseFullNameOrBungalowName() {
		return houseFullNameOrBungalowName;
	}

	public void setHouseFullNameOrBungalowName(String houseFullNameOrBungalowName) {
		this.houseFullNameOrBungalowName = houseFullNameOrBungalowName;
	}

	public String getHouseOrBungalowId() {
		return houseOrBungalowId;
	}

	public void setHouseOrBungalowId(String houseOrBungalowId) {
		this.houseOrBungalowId = houseOrBungalowId;
	}

	
	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	

	public String getHouseArea() {
		return houseArea + "平方米";
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseHolder() {
		return houseHolder;
	}

	public void setHouseHolder(String houseHolder) {
		this.houseHolder = houseHolder;
	}

	public String getHousePurpose() {
		return housePurpose;
	}

	public void setHousePurpose(String housePurpose) {
		this.housePurpose = housePurpose;
	}

	public List<PersonListVo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonListVo> persons) {
		this.persons = persons;
	}

	

	

}
