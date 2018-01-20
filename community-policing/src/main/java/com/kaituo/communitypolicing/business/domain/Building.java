package com.kaituo.communitypolicing.business.domain;

import java.util.UUID;

//聚合根

public class Building {


	private String buildingId;

	private String buildingName;


	private Coordinate coordinate;

	private String buildingType;
	
	private Double distance;

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Building( String buildingName, Coordinate coordinate, String buildingType) {
		super();
		this.buildingId=UUID.randomUUID().toString();
		this.buildingName = buildingName;
		this.coordinate = coordinate;
		this.buildingType = buildingType;
	}

	protected Building() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/*public Coordinate getCenterPointFromListOfCoordinates(List<Coordinate> coordinateList)  
	{  
	    int total = coordinateList.size();  
	    double X = 0, Y = 0, Z = 0;  
	    for(Coordinate coordinate : coordinateList)  
	    {  
	        double lat, lon, x, y, z;  
	        lat = coordinate.getLatitude() * Math.PI / 180;  
	        lon = coordinate.getLongitude() * Math.PI / 180;  
	        x = Math.cos(lat) * Math.cos(lon);  
	        y = Math.cos(lat) * Math.sin(lon);  
	        z = Math.sin(lat);  
	        X += x;  
	        Y += y;  
	        Z += z;  
	    }  
	    X = X / total;  
	    Y = Y / total;  
	    Z = Z / total;  
	    double Lon = Math.atan2(Y, X);  
	    double Hyp = Math.sqrt(X * X + Y * Y);  
	    double Lat = Math.atan2(Z, Hyp);  
	    return new Coordinate(Lat * 180 / Math.PI, Lon * 180 / Math.PI);  
	}  */

}
