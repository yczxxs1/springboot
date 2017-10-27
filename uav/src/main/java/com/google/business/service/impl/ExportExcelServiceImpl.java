package com.google.business.service.impl;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.PersonDAO;
import com.google.business.dao.UserDAO;
import com.google.business.dto.ActivityWebDTO;
import com.google.business.dto.LicenseWebDTO;
import com.google.business.dto.LocationDTO;
import com.google.business.dto.LocationWebDTO;
import com.google.business.dto.UavWebDTO;
import com.google.business.dto.UserWebDTO;
import com.google.business.model.Activity;
import com.google.business.model.LicenseEntity;
import com.google.business.model.LocationInfoEntity;
import com.google.business.model.Person;
import com.google.business.model.UavEntity;
import com.google.business.model.User;
import com.google.business.service.ActivityService;
import com.google.business.service.ExportExcelService;
import com.google.business.service.LicenseService;
import com.google.business.service.LocationService;
import com.google.business.service.UavService;
import com.google.business.service.UserService;
import com.google.business.util.poi.utils.ExcelUtil;


@Service
public class ExportExcelServiceImpl implements ExportExcelService{
	 
	@Autowired
	private UavService uavService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LicenseService licenseService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public ByteArrayOutputStream  uav(UavEntity uav) throws Exception {
		// TODO Auto-generated method stub
		List<UavEntity> list1 = uavService.getUavList(uav);
		List<UavWebDTO> list = new ArrayList<UavWebDTO>();
		for (UavEntity ue : list1){
			if ("0".equals(ue.getReview())) {
				ue.setReview("未审核");
			}else if ("1".equals(ue.getReview())) {
				ue.setReview("通过");
			}else {
				ue.setReview("不通过");
			}
			if ("0".equals(ue.getStatus())) {
				ue.setStatus("注销");
			}else if ("1".equals(ue.getStatus())) {
				ue.setStatus("正常");
			}else {
				ue.setStatus("报废");
			}
			list.add(new UavWebDTO(ue.getSnNumber(),ue.getFactoryName(),ue.getModelName(),ue.getBelongType()
					,ue.getStatus(),ue.getReview(),ue.getAreaName()));
		}
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "无人机信息表");
        map.put("total", list.size()+" 条");
        map.put("date", getDate());
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        try {
        	 ExcelUtil.getInstance().exportObj2ExcelByTemplate1(map, "web-info-template.xls", os,
                     list, UavWebDTO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os;
	}

	@Override
	public ByteArrayOutputStream user(User user) throws Exception {
		List<User> list1 = userService.getUserList(user);
		List<UserWebDTO> list = new ArrayList<UserWebDTO>();
		for (User u : list1){
			Person person = new Person();
			person.setUserId(u.getId());
			Person p = personDAO.selectOne(person);
			if ("0".equals(u.getSex())) {
				u.setSex("男");
			}else {
				u.setSex("女");
			}
			if (p==null) {
				p = new Person();
				p.setResidenceAddress("");
				p.setEmail("");
			}
			list.add(new UserWebDTO(u.getName(),u.getUserMobile(),u.getSex(),u.getCertNumber()
					,u.getNikeName(),u.getAreaName(),p.getResidenceAddress(),p.getEmail()));
		}
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "驾驶员信息表");
        map.put("total", list.size()+" 条");
        map.put("date", getDate());
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        try {
        	 ExcelUtil.getInstance().exportObj2ExcelByTemplate1(map, "web-info-template.xls", os,
                     list, UserWebDTO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os;
	}

	@Override
	public ByteArrayOutputStream license(LicenseEntity license) throws Exception {
		List<LicenseEntity> list1 = licenseService.getLicenseListByAreaId(license);
		List<LicenseWebDTO> list = new ArrayList<LicenseWebDTO>();
		for (LicenseEntity le : list1){
			if ("0".equals(le.getReview())) {
				le.setReview("未审核");
			}else if ("1".equals(le.getReview())) {
				le.setReview("通过");
			}else {
				le.setReview("不通过");
			}
			list.add(new LicenseWebDTO(le.getNikeName(),le.getLicenseTypeName(),le.getIssuingAuthority()
					,le.getLicenseLevel(),le.getReview(),le.getAreaName()));
		}
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "证书信息表");
        map.put("total", list.size()+" 条");
        map.put("date", getDate());
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        try {
        	 ExcelUtil.getInstance().exportObj2ExcelByTemplate1(map, "web-info-template.xls", os,
                     list, LicenseWebDTO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os;
		// TODO Auto-generated method stub
	}

	@Override
	public ByteArrayOutputStream location(LocationDTO locationDTO) throws Exception {
		List<LocationInfoEntity> list1 = locationService.getLocationForTime(locationDTO);
		List<LocationWebDTO> list = new ArrayList<LocationWebDTO>();
		for (LocationInfoEntity lie : list1){
			User user = userDAO.selectByPrimaryKey(lie.getUserId());
			list.add(new LocationWebDTO(user.getNikeName(),lie.getLocation(),lie.getHappenTime()
					,lie.getLongitude(),lie.getLatitude()));
		}
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "证书信息表");
        map.put("total", list.size()+" 条");
        map.put("date", getDate());
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        try {
        	 ExcelUtil.getInstance().exportObj2ExcelByTemplate1(map, "web-info-template.xls", os,
                     list, LocationWebDTO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os;
		
	}

	@Override
	public ByteArrayOutputStream activity(Activity activity) throws Exception {
		List<Activity> list1 = activityService.getActList(activity);
		List<ActivityWebDTO> list = new ArrayList<ActivityWebDTO>();
		
		for (Activity a : list1){
			if ("0".equals(a.getReview())) {
				a.setReview("未审核");
			}else if ("1".equals(a.getReview())) {
				a.setReview("通过");
			}else {
				a.setReview("不通过");
			}
			list.add(new ActivityWebDTO(a.getOrganizers(),a.getContractorName(),a.getContractorPhone()
					,a.getAreaName(),a.getAddress(),a.getReview()));
		}
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "活动信息表");
        map.put("total", list.size()+" 条");
        map.put("date", getDate());
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        try {
        	 ExcelUtil.getInstance().exportObj2ExcelByTemplate1(map, "web-info-template.xls", os,
                     list, ActivityWebDTO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os;
	}
	
	private String getDate() {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  hh时mm分ss秒");
	        return sdf.format(new Date());
	    }
}