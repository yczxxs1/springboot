package com.google.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.CompanysDAO;
import com.google.business.dao.LicenseDAO;
import com.google.business.dao.LocationInfoDAO;
import com.google.business.dao.PersonDAO;
import com.google.business.dao.PoliceDAO;
import com.google.business.dao.UavDAO;
import com.google.business.dao.UserDAO;
import com.google.business.dto.UserDTO;
import com.google.business.model.LicenseEntity;
import com.google.business.model.LocationInfoEntity;
import com.google.business.model.Person;
import com.google.business.model.UavEntity;
import com.google.business.model.User;
import com.google.business.service.InquiryService;
import com.google.common.exception.ServiceException;



@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private UavDAO uavDAO;
    
    @Autowired
    private PersonDAO personDAO;
    
    @Autowired
    private LicenseDAO licenseDAO;
    
    @Autowired
    private PoliceDAO policeDAO;
    
    @Autowired
    private LocationInfoDAO locationDAO;
    
    @Autowired
    private CompanysDAO companyDAO;

	@Override
	public Map<String, Map<String,Object>> getList(String id) {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		userDTO.setCertNumber(id);
		UavEntity uav = new UavEntity();
		UavEntity uav2 = new UavEntity();
		LicenseEntity license = new LicenseEntity();
		LocationInfoEntity location = new LocationInfoEntity();
		uav.setSnNumber(id);
		List<User> list;
		List<UavEntity> list1;
		//User user1 = new User();
		Map<String, Map<String,Object>> map = new HashMap<String, Map<String,Object>>();
		if (userDAO.selectList(userDTO).size()==0 && uavDAO.selectUavList(uav).size()==0) {
			throw new ServiceException("无效查询！");
		}
		//身份证号查询
		else if (userDAO.selectList(userDTO).size()!=0 && uavDAO.selectUavList(uav).size()==0) {
			list = userDAO.selectList(userDTO);
			for (User u : list) {
				uav2.setBelongId(u.getId());
				license.setUserId(u.getId());
				location.setUserId(u.getId());
				if ("0".equals(u.getUserType())) {
					Person person = new Person();
					person.setUserId(u.getId());
					Map<String, Object> map1 = new HashMap<String, Object>();
					map1.put("user", u);
					map1.put("person", personDAO.selectOne(person));
					map1.put("uav", uavDAO.selectUavList(uav2));
					map1.put("license", licenseDAO.selectLicenseList(license));
					map1.put("location", locationDAO.selectLocationInfo(location));
					map.put("0", map1);
				}
				else if ("3".equals(u.getUserType())) {
					Map<String, Object> map2 = new HashMap<String, Object>();
					map2.put("user", u);
					map2.put("police", policeDAO.selectByUserId(u.getId()));
					map2.put("uav", uavDAO.selectUavList(uav2));
					map2.put("license", licenseDAO.selectLicenseList(license));
					map2.put("location", locationDAO.selectLocationInfo(location));
					map.put("3", map2);
				}
				else {
					Map<String, Object> map3 = new HashMap<String, Object>();
					map3.put("user", u);
					map3.put("company", companyDAO.selectByUserId(u.getId()));
					map3.put("uav", uavDAO.selectUavList(uav2));
					map3.put("license", licenseDAO.selectLicenseList(license));
					map3.put("location", locationDAO.selectLocationInfo(location));
					map.put(u.getUserType(), map3);
				}
			}
		}
		//SN编号查询
		else if (userDAO.selectList(userDTO).size()==0 && uavDAO.selectUavList(uav).size()!=0) {
			list1 = uavDAO.selectUavList(uav);
			if (list1.size()>1) {
				throw new ServiceException("无人机不唯一！");
			}
			for (UavEntity ue : list1) {
				license.setUserId(ue.getBelongId());
				location.setUserId(ue.getBelongId());
				User user1 = userDAO.selectByPrimaryKey(ue.getBelongId());
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("user", user1);
				if ("0".equals(user1.getUserType())) {
					Person person = new Person();
					person.setUserId(ue.getBelongId());
					map1.put("person", personDAO.selectOne(person));
				}
				else if ("3".equals(user1.getUserType())) {
					map1.put("police", policeDAO.selectByUserId(ue.getBelongId()));
				}
				else {
					map1.put("company", companyDAO.selectByUserId(ue.getBelongId()));
				}
				map1.put("uav", ue);
				map1.put("license", licenseDAO.selectLicenseList(license));
				map1.put("location", locationDAO.selectLocationInfo(location));
				map.put(user1.getUserType(), map1);
			}
		}
		return map;
	}

	@Override
	public void getDetial(String userId) {
		// TODO Auto-generated method stub
		
	}

}
