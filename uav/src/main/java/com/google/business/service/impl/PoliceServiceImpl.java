package com.google.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.business.dao.AreaDAO;
import com.google.business.dao.CityDAO;
import com.google.business.dao.PoliceDAO;
import com.google.business.dao.ProvinceDAO;
import com.google.business.dao.UserDAO;
import com.google.business.model.Area;
import com.google.business.model.City;
import com.google.business.model.Police;
import com.google.business.model.Province;
import com.google.business.model.User;
import com.google.business.service.PoliceService;
import com.google.common.exception.ServiceException;

@Service
public class PoliceServiceImpl implements PoliceService {
	@Autowired
	private PoliceDAO policeDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AreaDAO areaDAO;
	@Autowired
	private CityDAO cityDAO;
	@Autowired
	private ProvinceDAO provinceDAO;

	@Override
	@Transactional
	public void saveOrUpdatePolice(Police police, String areaId) {
		//校验userId和areaId
		String userId=police.getUserId();
		if(userId==null){
			throw new ServiceException("非法！");
		}
		User user0=userDAO.selectByPrimaryKey(userId);
		//更新区域id和用户状态
		User user = new User();
		if("0".equals(user0.getUserStatus())){
			if(areaId==null){
				throw new ServiceException("非法！");//状态为0不能为空
			}
			user.setUserStatus("2");
		}
		
		user.setAreaId(areaId);//可以为空！
		user.setId(userId);
		userDAO.updateByPrimaryKeySelective(user);
		// 更新或保存警用信息
		Police police2=policeDAO.selectByUserId(userId);
		if ( police2 == null) {
			policeDAO.insertSelective(police);
		} else {
			police.setId(police2.getId());
			policeDAO.updateByPrimaryKey(police);
		}
	}

	@Override
	public Police getPoliceDetail(String userId) {
		// TODO Auto-generated method stub
		Police police = new Police();
		 //查询个人省市区位置信息
		User user = userDAO.selectByPrimaryKey(userId);
	    Area area=areaDAO.selectByPrimaryKey(user.getAreaId());
		//市
		City city=new City();
		city.setCityId(area.getAreaFatherId());;
		city=cityDAO.selectOne(city);
		//省
		Province province=new Province();
	    province.setProvinceId(city.getCityFatherId());
	    province=provinceDAO.selectOne(province);
		police.setUserId(userId);
		Police police1 = policeDAO.selectOne(police);
		police1.setArea(area);
		police1.setCity(city);
		police1.setProvince(province);
		return police1;
	}
}
