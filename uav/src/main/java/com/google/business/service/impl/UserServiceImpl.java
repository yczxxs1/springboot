package com.google.business.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.conversion.UserConversion;
import com.google.business.dao.ActivityDAO;
import com.google.business.dao.AreaDAO;
import com.google.business.dao.CityDAO;
import com.google.business.dao.CompanyPhotoDAO;
import com.google.business.dao.CompanysDAO;
import com.google.business.dao.LicenseDAO;
import com.google.business.dao.LicensePhotoDAO;
import com.google.business.dao.PersonDAO;
import com.google.business.dao.PoliceDAO;
import com.google.business.dao.ProvinceDAO;
import com.google.business.dao.SmsDAO;
import com.google.business.dao.UavDAO;
import com.google.business.dao.UavPhotoDAO;
import com.google.business.dao.UserDAO;
import com.google.business.dto.ActivityDTO;
import com.google.business.model.Activity;
import com.google.business.model.Area;
import com.google.business.model.City;
import com.google.business.model.Companys;
import com.google.business.model.LicenseEntity;
import com.google.business.model.LicensePhotoEntity;
import com.google.business.model.Person;
import com.google.business.model.Police;
import com.google.business.model.Province;
import com.google.business.model.SmsValidateEntity;
import com.google.business.model.UavEntity;
import com.google.business.model.UavPhotoEntity;
import com.google.business.model.User;
import com.google.business.service.ActivityService;
import com.google.business.service.UserService;
import com.google.business.util.fastDFS.FastDFSFileUtils;
import com.google.common.exception.ServiceException;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SmsDAO smsDAO;
	
	@Autowired
	private CityDAO cityDAO;
	
	@Autowired
	private ProvinceDAO provinceDAO;
	
	@Autowired
	private AreaDAO areaDAO;
	
	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private PoliceDAO policeDAO;
	
	@Autowired
	private CompanysDAO companyDAO;
	
	@Autowired
	private CompanyPhotoDAO cptDAO;
	
	@Autowired
	private LicenseDAO licenseDAO;
	
	@Autowired
	private LicensePhotoDAO licensePhotoDAO;
	
	@Autowired
	private ActivityService actService;
	
	@Autowired
	private UavDAO uavDAO;

	@Autowired
	private UavPhotoDAO uavPhotoDAO;
	
	@Autowired
	private ActivityDAO actDAO;
	
	@Autowired
	private UserConversion userConversion;
	
	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		// 手机号和密码
		User user = new User();
		user.setUserMobile(userName);
		user.setPassword(password);
		User user1 = userDAO.selectOne(user);
		// 用户名和密码
		user.setUserMobile(null);
		user.setName(userName);
		user.setPassword(password);
		User user2 = userDAO.selectOne(user);

		if (user1 == null && user2 == null) {
			throw new ServiceException("用户名或密码不正确！");
		}
		if (user1 != null) {
			user = user1;
		} else {
			user = user2;
		}
		if ("9".equals(user.getUserStatus())) {
			throw new ServiceException("您已经被禁用！");
		} else {
			// 更新登录时间
			User user3 = new User();
			user3.setId(user.getId());
			user3.setLastLoginDate(new Date());
			userDAO.updateByPrimaryKeySelective(user3);

		}
		//根据areaId获取省市区
		String userStatus=user.getUserStatus();
		
	
		if("0".equals(userStatus)){
			//无详细信息
			return user;
		}else{
			//区域信息
			Area area=areaDAO.selectByPrimaryKey(user.getAreaId());
			//城市信息
			City city=new City();
			city.setCityId(area.getAreaFatherId());
			city=cityDAO.selectOne(city);
			//省
			Province province=new Province();
		    province.setProvinceId(city.getCityFatherId());
		    province=provinceDAO.selectOne(province);
			
			String userType=user.getUserType();
			
			if("0".equals(userType)){
				Person person=new Person();
				person.setUserId(user.getId());
				person=personDAO.selectOne(person);
				person.setProvince(province);
				person.setCity(city);
				person.setArea(area);
				user.setPerson(person);
			}else if("3".equals(userType)){
				Police police=new Police();
				police.setUserId(user.getId());
				police=policeDAO.selectOne(police);
				
				police.setArea(area);
				
				user.setPolice(police);
				
			}else if("1".equals(userType)){
				Companys company =companyDAO.selectByUserId(user.getId());
				company.setArea(area);
				company.setProvince(province);
				company.setCity(city);
				company.setCompanyPhotos(cptDAO.selectListByCompanyId(company.getId()));
				user.setCompany(company);
				
			}else if("2".equals(userType)){
				Companys company =companyDAO.selectByUserId(user.getId());
				company.setArea(area);
				company.setProvince(province);
				company.setCity(city);
				company.setCompanyPhotos(cptDAO.selectListByCompanyId(company.getId()));
				user.setSale(company);
			}else{
				throw new ServiceException("非法用户类型！");
			}
			return user;
		}
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.setName(user.getName());
		User user2 = new User();
		user2.setUserMobile(user.getUserMobile());
		User user3=new User();
		user3.setCertNumber(user.getCertNumber());
		user3.setUserType(user.getUserType());
		if (userDAO.selectOne(user1) == null&&userDAO.selectOne(user2) == null&&userDAO.selectOne(user3)==null) {
			userDAO.insertSelective(user);
		} else {
			throw new ServiceException("用户已经存在！");
		}

	}

	@Override
	public void forget(String mobile, String code, String password) {
		// TODO Auto-generated method stub
		SmsValidateEntity smsValidateEntity = new SmsValidateEntity();
		User userinfoEntity = new User();
		Date currentTime = new Date();// 当前时间
		userinfoEntity.setUserMobile(mobile);
		if (userDAO.selectOne(userinfoEntity) == null) {
			throw new ServiceException("你还没注册呢！");
		} else {
			smsValidateEntity.setPhoneNumber(mobile);
			smsValidateEntity.setCode(code);
			smsValidateEntity = smsDAO.selectOne(smsValidateEntity);
			if (smsValidateEntity == null) {
				throw new ServiceException("手机号或者验证码不正确");
			} else {
				if (currentTime.before(smsValidateEntity.getExpireDate())) {
					userinfoEntity.setUserMobile(mobile);
					userinfoEntity=userDAO.selectOne(userinfoEntity);
					User user1=new User();
					user1.setPassword(password);
					user1.setId(userinfoEntity.getId());
					userDAO.updateByPrimaryKeySelective(user1);// 根据手机号修改密码
				} else {
					throw new ServiceException("验证码已过期，请重新获取！");
				}
			}

		}
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		if(user.getId()==null){
			throw new ServiceException("非法！");
		}
		userDAO.updateByPrimaryKeySelective(user);
		
	}

	@Override
	public String uploadAvatar(String userId,File file) throws Exception {
		// TODO Auto-generated method stub
		try {
			if(userId==null){
				throw new ServiceException("非法！");
			}
			User user=userDAO.selectByPrimaryKey(userId);
			String avatar=user.getAvatar();
			if(avatar!=null){
				FastDFSFileUtils.deleteFileToDfs(avatar);
			}
			String photoUrl = FastDFSFileUtils.uploadFileToDfs(file);//上传文件服务器
			User user1=new User();
			user1.setAvatar(photoUrl);
			user1.setId(userId);
			userDAO.updateByPrimaryKeySelective(user1);//入库
			return photoUrl;
		} finally {
			// TODO: handle finally clause
			file.delete();
		}
		
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user=userDAO.selectByPrimaryKey(userId);
		if(user==null){
			throw new ServiceException("该用户不存在！");
		}
		if("0".equals(user.getUserStatus())){
			throw new ServiceException("该用户信息未完善！");
		}
		//区域信息
		Area area=areaDAO.selectByPrimaryKey(user.getAreaId());
		//城市信息
		City city=new City();
		city.setCityId(area.getAreaFatherId());
		city=cityDAO.selectOne(city);
		//省
		Province province=new Province();
	    province.setProvinceId(city.getCityFatherId());
	    province=provinceDAO.selectOne(province);
		
		String userType=user.getUserType();
		
		if("0".equals(userType)){
			Person person=new Person();
			person.setUserId(user.getId());
			person=personDAO.selectOne(person);
			person.setProvince(province);
			person.setCity(city);
			person.setArea(area);
			user.setPerson(person);
		}else if("3".equals(userType)){
			Police police=new Police();
			police.setUserId(user.getId());
			police=policeDAO.selectOne(police);
			
			police.setArea(area);
			
			user.setPolice(police);
			
		}else if("1".equals(userType)){
			Companys company =companyDAO.selectByUserId(user.getId());
			company.setArea(area);
			company.setProvince(province);
			company.setCity(city);
			company.setCompanyPhotos(cptDAO.selectListByCompanyId(company.getId()));
			user.setCompany(company);
			
		}else if("2".equals(userType)){
			Companys company =companyDAO.selectByUserId(user.getId());
			company.setArea(area);
			company.setProvince(province);
			company.setCity(city);
			company.setCompanyPhotos(cptDAO.selectListByCompanyId(company.getId()));
			user.setSale(company);
		}else{
			throw new ServiceException("非法用户类型！");
		}
		
		return user;
	}

	@Override
	public void updatePassword(String oldPassword, String newPassword, String userId) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setPassword(oldPassword);
		user.setId(userId);
		if(userDAO.selectOne(user)==null){
			throw new ServiceException("旧密码不正确！");
		}
		user.setPassword(newPassword);
		userDAO.updateByPrimaryKeySelective(user);
	}

	/**
	 * <p>web端接口：获取用户列表
	 * 
	 */
	@Override
	public List<User> getUserList(User user) {
		// TODO Auto-generated method stub
		
		return userDAO.selectList(userConversion.convertToDTO(user));
	}
	
    //web端接口：获取用户详情
	@Override
	public User getUserDetail(String userId) {
		// TODO Auto-generated method stub
		    User user = userDAO.selectByPrimaryKey(userId);
		    if("0".equals(user.getUserStatus())){
		    	throw new ServiceException("该用户信息未完善！");
		    }
		    //查询个人省市区位置信息
		    Area area=areaDAO.selectByPrimaryKey(user.getAreaId());
			//市
			City city=new City();
			city.setCityId(area.getAreaFatherId());;
			city=cityDAO.selectOne(city);
			//省
			Province province=new Province();
		    province.setProvinceId(city.getCityFatherId());
		    province=provinceDAO.selectOne(province);
		    //个人基本信息
			Person person = new Person();
			person.setUserId(userId);
			Person person1 = personDAO.selectOne(person);
			person1.setArea(area);
			person1.setCity(city);
			person1.setProvince(province);
			user.setPerson(person1);
			//个人相关执照信息
			LicenseEntity licenseEntity = new LicenseEntity();
			licenseEntity.setUserId(userId);
			List<LicenseEntity> list = licenseDAO.selectLicenseList(licenseEntity);
			user.setLicense(list);
			//个人相关无人机信息
			UavEntity uavEntity = new UavEntity();
			uavEntity.setBelongId(userId);
			List<UavEntity> list1 = uavDAO.selectUavList(uavEntity);
			user.setUav(list1);	
		    return user;
	}

	@Override
	public void delete(String userId) {
		User user = userDAO.selectByPrimaryKey(userId);
		//删除用户（四种类型）详情
		if (user == null) {
	    	throw new ServiceException("该用户不存在！");
		}
		else if ("0".equals(user.getUserType())) {
			personDAO.deleteByPrimaryKey(userId);
		} 
		else if("3".equals(user.getUserType())){
			policeDAO.deleteByPrimaryKey(userId);
		}
		else {
			companyDAO.deleteByPrimaryKey(userId);
		}
		//删除名下无人机及照片
		UavEntity uav = new UavEntity();
		UavPhotoEntity uavPhoto = new UavPhotoEntity();
		uav.setBelongId(userId);
		List<UavEntity> list1 = uavDAO.selectUavList(uav);
		for (UavEntity ue : list1) {
			uavPhoto.setUavId(ue.getId());
			List<UavPhotoEntity> upelist = uavPhotoDAO.selectUavPhotoList(uavPhoto);
			for (UavPhotoEntity upe : upelist) {
				uavPhotoDAO.deleteByPrimaryKey(uavPhoto);
				upe.getPhotoUrl();
			}
			uavDAO.deleteByPrimaryKey(ue); 
		}
		//删除名下证书及照片
		LicenseEntity license = new LicenseEntity();
		license.setUserId(userId);
		List<LicenseEntity> list2 = licenseDAO.selectLicenseList(license);
		LicensePhotoEntity licensePhotoEntity = new LicensePhotoEntity();
		for (LicenseEntity le : list2) {
			licensePhotoEntity.setLicenseId(le.getId());
			List<LicensePhotoEntity> lpeList = licensePhotoDAO.selectLicensePhotoList(licensePhotoEntity);
			for (LicensePhotoEntity lpe : lpeList) {
				licensePhotoDAO.deleteByPrimaryKey(licensePhotoEntity);
				lpe.getPhotoUrl();
			}
			licenseDAO.deleteByPrimaryKey(le);
		}
		//删除名下活动及活动下所有内容
		ActivityDTO act = new ActivityDTO();
		act.setUserId(userId);
		List<Activity> list3 = actDAO.selectActList(act);
		for (Activity ac : list3) {
			actService.delAct(ac.getId());
		}
		//删除用户
		userDAO.deleteByPrimaryKey(userId);
	}
}
