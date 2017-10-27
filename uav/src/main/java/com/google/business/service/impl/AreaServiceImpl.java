package com.google.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.google.business.dao.AreaDAO;
import com.google.business.dao.CityDAO;
import com.google.business.dao.ProvinceDAO;
import com.google.business.model.Area;
import com.google.business.model.City;
import com.google.business.model.Province;
import com.google.business.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private ProvinceDAO provinceDAO;
	@Autowired
	private CityDAO cityDAO;
	@Autowired
	private AreaDAO areaDAO;

	@Override
	public List<Province> selectProvince(Province province) {
		// TODO Auto-generated method stub
		List<Province> list = provinceDAO.selectAll();
		return list;
	}

	@Override
	public List<City> selectCity(City city) {
		// TODO Auto-generated method stub
		List<City> list = cityDAO.selectAll(city);

		return list;
	}

	@Override
	public List<Area> selectArea(Area area) {
		// TODO Auto-generated method stub
		List<Area> list = areaDAO.selectAll(area);
		return list;
	}

	@Override
	public City getCity(City city) {
		// TODO Auto-generated method stub
		return cityDAO.selectOne(city);
	}

	@Override
	public JSONObject getWuxi() {
		// TODO Auto-generated method stub
		City city = new City();
		city.setCityName("无锡市");
		city = cityDAO.selectOne(city);
		Province province = new Province();
		province.setProvinceId(city.getCityFatherId());
		province=provinceDAO.selectOne(province);
		JSONObject jo = new JSONObject();
		jo.put("city", city);
		jo.put("province", province);
		return jo;
	}

	@Override
	public List<Area> getWuxiArea() {
		// TODO Auto-generated method stub
		City city = new City();
		city.setCityName("无锡市");
		city = cityDAO.selectOne(city);
		Area area=new Area();
		area.setAreaFatherId(city.getCityId());	
		return areaDAO.selectAll(area);
	}
}
