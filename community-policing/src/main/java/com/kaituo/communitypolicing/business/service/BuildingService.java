package com.kaituo.communitypolicing.business.service;

import java.util.List;

import com.kaituo.communitypolicing.business.domain.Bungalow;
import com.kaituo.communitypolicing.business.domain.Coordinate;
import com.kaituo.communitypolicing.business.domain.Floor;
import com.kaituo.communitypolicing.business.domain.House;
import com.kaituo.communitypolicing.business.domain.TallBuilding;
import com.kaituo.communitypolicing.business.exception.BuildingNotFoundException;
import com.kaituo.communitypolicing.business.exception.HouseNotFoundException;
import com.kaituo.communitypolicing.business.vo.BuildingListVo;

public interface BuildingService {
	
	/**
	 * 根据当前坐标获取列表
	 * @param coordinate
	 * @return List<BuildingListVo>
	 */
	public List<BuildingListVo> listByCurrentCoordinates(Coordinate coordinate);
	
	
	/**
	 * 获取层户结构楼房信息
	 * @param buildingId
	 * @return TallBuilding
	 * @throws BuildingNotFoundException
	 */
	public TallBuilding getTallBuilding(String buildingId) throws BuildingNotFoundException;
	
	
	/**
	 * 获取楼层信息
	 * @param unitId
	 * @return List<Floor>
	 */
	public List<Floor> getFloors(String unitId);
	
	/**
	 * 获取室信息
	 * @param houseId
	 * @return House
	 * @throws HouseNotFoundException
	 */
	public House getHouse(String houseId) throws HouseNotFoundException;
	
	/**
	 * 获取独栋信息
	 * @param buildingId
	 * @return Bungalow
	 * @throws BuildingNotFoundException
	 */
	public Bungalow getBungalow(String buildingId) throws BuildingNotFoundException;

}
