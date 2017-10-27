package com.google.business.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.business.dao.AdminDAO;
import com.google.business.dao.AreaDAO;
import com.google.business.model.AdminEntity;
import com.google.business.model.Area;
import com.google.business.service.AdminService;
import com.google.common.exception.ServiceException;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDao;

	@Autowired
	private AreaDAO areaDAO;

	@Value("${admin.password}")
	private String adminPwd;

	@Override
	public void createAdmin(AdminEntity adminEntity) {
		AdminEntity adminEntity0 = new AdminEntity();
		adminEntity0.setName(adminEntity.getName());
		AdminEntity admin = adminDao.selectOne(adminEntity);
		if (admin != null) {
			throw new ServiceException("用户名已存在！");
		}
		if (adminEntity.getEffectiveDate() == null) {
			Calendar cld = Calendar.getInstance();
			cld.setTime(new Date());
			cld.add(Calendar.MONTH, +3);
			Date effectiveDate = cld.getTime();
			adminEntity.setEffectiveDate(effectiveDate);
		}
		adminEntity.setPassword(DigestUtils.md5Hex(adminPwd));
		adminDao.insertAdmin(adminEntity);
	}

	@Override
	public void delAdminBatch(List<String> list) {

		for (String userId1 : list) {
			AdminEntity adminEntity = new AdminEntity();
			adminEntity.setId(userId1);
			adminDao.deleteAdmin(adminEntity);
		}

	}

	@Override
	public List<AdminEntity> getAdminList(AdminEntity adminEntity) {
		List<AdminEntity> list = adminDao.selectAdmin(adminEntity);
		// set区域名称
		for (AdminEntity ae : list) {
			Area area = areaDAO.selectByPrimaryKey(ae.getAreaId());
			if (area != null) {
				ae.setAreaName(area.getAreaName());
			}
		}
		return list;
	}

	@Override
	public AdminEntity getDetail(AdminEntity adminEntity) {

		return getAdminEntityIncludeAreaName(adminDao.selectOne(adminEntity));
	}

	@Override
	public void updateAdmin(AdminEntity adminEntity) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(adminEntity.getId())) {
			throw new IllegalArgumentException("The 'id' parameter must not be null or empty");
		}
		adminDao.updateAdmin(adminEntity);

	}

	@Override
	public void resetPasswordBatch(List<String> list) {
		// TODO Auto-generated method stub
		for (String userId1 : list) {
			AdminEntity adminEntity = new AdminEntity();
			adminEntity.setId(userId1);
			adminEntity.setPassword(DigestUtils.md5Hex(adminPwd));
			adminDao.updateAdmin(adminEntity);
		}

	}

	@Override
	public void editPassword(String oldPassword, String newPassword, String userId) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setId(userId);
		adminEntity.setPassword(oldPassword);
		if (adminDao.selectAdmin(adminEntity) == null) {
			throw new ServiceException("校验不通过！");
		}
		adminEntity.setPassword(newPassword);
		adminDao.updateAdmin(adminEntity);

	}

	@Override
	public AdminEntity login(String name, String password) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setName(name);
		adminEntity.setPassword(password);
		AdminEntity adminEntity1 = adminDao.selectOne(adminEntity);
		if (adminEntity1 == null) {
			throw new ServiceException("用户名或密码错误！");
		}
		//校验有效期
		Date effectiveDate=adminEntity1.getEffectiveDate();
		if(effectiveDate!=null) {
			if (effectiveDate.before(new Date())) {
	            throw new ServiceException("您的账户到期了，请联系管理员！");
			}
		}
		//校验状态
		if ("1".equals(adminEntity1.getStatus())) {
			throw new ServiceException("您被禁用了，请联系超级管理员！");
		}
		
		adminEntity1 = getAdminEntityIncludeAreaName(adminEntity1);
		
		if(adminEntity1.getPassword().equals(DigestUtils.md5Hex(adminPwd))) {
			adminEntity1.setResetStatus("重新修改密码！");
		}
		return adminEntity1;
	}

	/**
	 * 
	 * <p>
	 * 获取areaName 内部方法
	 * 
	 * @param adminEntity
	 * @return
	 */
	public AdminEntity getAdminEntityIncludeAreaName(AdminEntity adminEntity) {
		// 区域串转换成区域id数组
		String areaIds = adminEntity.getAreaId();
		if (areaIds != null) {
			String areaId[] = areaIds.split(",");
			// 拼接区域名字符串
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < areaId.length; i++) {
				String areaName = areaDAO.selectByPrimaryKey(areaId[i]).getAreaName();
				if (i == 0) {
					buffer.append(areaName);
				} else {
					buffer.append("," + areaName);
				}
			}
			adminEntity.setAreaName(buffer.toString());
		}
		return adminEntity;
	}
}
