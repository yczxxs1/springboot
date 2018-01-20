package com.kaituo.communitypolicing.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaituo.communitypolicing.business.condition.Condition;
import com.kaituo.communitypolicing.business.domain.Bungalow;
import com.kaituo.communitypolicing.business.domain.Coordinate;
import com.kaituo.communitypolicing.business.domain.Floor;
import com.kaituo.communitypolicing.business.domain.House;
import com.kaituo.communitypolicing.business.domain.HousePopulationInfo;
import com.kaituo.communitypolicing.business.domain.PersonIsKey;
import com.kaituo.communitypolicing.business.domain.PersonType;
import com.kaituo.communitypolicing.business.domain.TallBuilding;
import com.kaituo.communitypolicing.business.exception.BuildingNotFoundException;
import com.kaituo.communitypolicing.business.exception.HouseNotFoundException;
import com.kaituo.communitypolicing.business.repository.BuildingRepository;
import com.kaituo.communitypolicing.business.repository.PersonRepository;
import com.kaituo.communitypolicing.business.service.BuildingService;
import com.kaituo.communitypolicing.business.vo.BuildingListVo;

@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private PersonRepository personRepository;
	

	@Override
	public List<BuildingListVo> listByCurrentCoordinates(Coordinate coordinate) {
		// TODO Auto-generated method stub
		return buildingRepository.selectListByCoordinate(coordinate);
	}

	@Override
	public TallBuilding getTallBuilding(String buildingId) {
		// TODO Auto-generated method stub
		
		TallBuilding tallBuilding=buildingRepository.selectTallBuildingById(buildingId);
		if(tallBuilding==null) throw new BuildingNotFoundException(buildingId);
		return tallBuilding;
	}
	

	private HousePopulationInfo getHousePopulationInfo(String houseId) {
		Condition condition=new Condition();
		condition.setHouseId(houseId);
		condition.setPersonType(PersonType.PERMANENT.getCode());
		Integer premanentPopulation=personRepository.selectCountByHouse(condition);
		condition.setPersonType(PersonType.FLOATING.getCode());
		Integer floatingPopulation=personRepository.selectCountByHouse(condition);
		condition.setPersonType(PersonType.OVERSEA.getCode());
		Integer overseasPopulation=personRepository.selectCountByHouse(condition);
		condition.setPersonType(null);
		condition.setPersonIskey(PersonIsKey.key.getCode());
	    Integer keyPopulation=personRepository.selectCountByHouse(condition);
		return new HousePopulationInfo(premanentPopulation,floatingPopulation,keyPopulation,overseasPopulation);
		
	}

	@Override
	public List<Floor> getFloors(String unitId) {
		// TODO Auto-generated method stub
		List<Floor> floors=buildingRepository.selectFloorByUnitId(unitId);
		for(Floor floor:floors) {
			for(House house:floor.getHouses()) {
				house.setHousePopulationInfo(getHousePopulationInfo(house.getHouseId()));
			}
		}
		return floors;
	}

	@Override
	public House getHouse(String houseId) {
		// TODO Auto-generated method stub
		House house=buildingRepository.selectByHouseId(houseId);
		if(house==null) throw new HouseNotFoundException(houseId);
		return house;
	}

	@Override
	public Bungalow getBungalow(String buildingId) {
		// TODO Auto-generated method stub
		Bungalow bungalow=buildingRepository.selectBungalowById(buildingId);
		if(bungalow==null) throw new BuildingNotFoundException(buildingId);
		return bungalow;
	}
	
	

}
