package com.kaituo.communitypolicing.business.domain;

import java.util.List;


public class TallBuilding extends Building {

	
	private List<Unit> units;

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	protected TallBuilding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TallBuilding(String buildingName, Coordinate coordinate, String buildingType) {
		super(buildingName, coordinate, buildingType);
		// TODO Auto-generated constructor stub
	}

	
}
