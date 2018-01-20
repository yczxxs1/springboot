package com.kaituo.communitypolicing.business.domain;

import io.swagger.annotations.ApiModelProperty;

public class HousePopulationInfo {
	@ApiModelProperty("常住人口")
	private Integer permanentPopulation;//常住人口
	@ApiModelProperty("流动人口")
	private Integer floatingPopulation;//流动人口
	@ApiModelProperty("重点人口")
	private Integer keyPopulation;//重点人口
	@ApiModelProperty("海外人口")
	private Integer overseasPopulation;//海外人口
	public Integer getPermanentPopulation() {
		return permanentPopulation;
	}
	public void setPermanentPopulation(Integer permanentPopulation) {
		this.permanentPopulation = permanentPopulation;
	}
	public Integer getFloatingPopulation() {
		return floatingPopulation;
	}
	public void setFloatingPopulation(Integer floatingPopulation) {
		this.floatingPopulation = floatingPopulation;
	}
	public Integer getKeyPopulation() {
		return keyPopulation;
	}
	public void setKeyPopulation(Integer keyPopulation) {
		this.keyPopulation = keyPopulation;
	}
	public Integer getOverseasPopulation() {
		return overseasPopulation;
	}
	public void setOverseasPopulation(Integer overseasPopulation) {
		this.overseasPopulation = overseasPopulation;
	}
	public HousePopulationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HousePopulationInfo(Integer permanentPopulation, Integer floatingPopulation, Integer keyPopulation,
			Integer overseasPopulation) {
		super();
		this.permanentPopulation = permanentPopulation;
		this.floatingPopulation = floatingPopulation;
		this.keyPopulation = keyPopulation;
		this.overseasPopulation = overseasPopulation;
	}
	
	
	
}
