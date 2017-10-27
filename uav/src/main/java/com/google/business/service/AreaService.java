package com.google.business.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.business.model.Area;
import com.google.business.model.City;
import com.google.business.model.Province;

public interface AreaService {

	public List<Province> selectProvince (Province province);
	public List<City> selectCity (City city);
	public List<Area> selectArea (Area area);
	public City getCity(City city);
	public JSONObject getWuxi();
	public List<Area> getWuxiArea();

}

