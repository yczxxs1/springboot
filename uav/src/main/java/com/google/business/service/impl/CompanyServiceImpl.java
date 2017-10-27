package com.google.business.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.business.dao.AreaDAO;
import com.google.business.dao.CityDAO;
import com.google.business.dao.CompanyPhotoDAO;
import com.google.business.dao.CompanysDAO;
import com.google.business.dao.ProvinceDAO;
import com.google.business.dao.UserDAO;
import com.google.business.model.Area;
import com.google.business.model.City;
import com.google.business.model.CompanyPhoto;
import com.google.business.model.Companys;
import com.google.business.model.Province;
import com.google.business.model.User;
import com.google.business.service.CompanyService;
import com.google.business.util.fastDFS.FastDFSFileUtils;
import com.google.common.exception.ServiceException;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CompanysDAO companyDAO;

	@Autowired
	private CompanyPhotoDAO cpDAO;

	@Autowired
	private AreaDAO areaDAO;

	@Autowired
	private CityDAO cityDAO;

	@Autowired
	private ProvinceDAO provinceDAO;

	@Override
	@Transactional
	public void saveOrUpdate(Companys company, List<File> files) throws Exception {
		// TODO Auto-generated method stub
		try {
			String userId = company.getUserId();
			if (userId == null) {
				throw new ServiceException("非法！");
			}
			String areaId=company.getArea().getAreaId();
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
			
			// 更新或保存单位信息
			Companys company2 = companyDAO.selectByUserId(userId);
			if (company2 == null) {
				// 新增单位信息
				companyDAO.insertSelective(company);
			} else {// 更新单位信息
				String companyId = company2.getId();
				List<CompanyPhoto> list = cpDAO.selectListByCompanyId(companyId);
				// 删库
				cpDAO.deleteByCompanyId(companyId);
				company.setId(companyId);
				companyDAO.updateByPrimaryKeySelective(company);
				// 删除文件服务器上图片
				for (CompanyPhoto cp : list) {
					FastDFSFileUtils.deleteFileToDfs(cp.getCertPhoto());
				}

			}

			for (File file : files) {
				String photoUrl = FastDFSFileUtils.uploadFileToDfs(file);// 上传文件服务器
				cpDAO.insertSelective(new CompanyPhoto(company.getId(), photoUrl, new Date()));// 图片地址入库
			}
		} finally {
			// TODO: handle finally clause
			for (File file : files) {
				file.delete();
			}
		}

	}

	@Override
	public List<CompanyPhoto> getCompanyPhotoByCompanyId(String companyId) {
		// TODO Auto-generated method stub
		return cpDAO.selectListByCompanyId(companyId);
	}

	@Override
	public Companys getCompanyDetail(String userId) {
		// TODO Auto-generated method stub
		User user = userDAO.selectByPrimaryKey(userId);
		if("0".equals(user.getUserStatus())){
			throw new ServiceException("该用户未完善信息！");
		}
		// 查询个人省市区位置信息
		Area area = areaDAO.selectByPrimaryKey(user.getAreaId());
		// 市
		City city = new City();
		city.setCityId(area.getAreaFatherId());
		;
		city = cityDAO.selectOne(city);
		// 省
		Province province = new Province();
		province.setProvinceId(city.getCityFatherId());
		province = provinceDAO.selectOne(province);
		Companys company = new Companys();
		company.setUserId(userId);
		Companys company1 = companyDAO.selectOne(company);
		if (company1 == null) {
			throw new ServiceException("该用户不存在！");
		}
		company1.setArea(area);
		company1.setCity(city);
		company1.setProvince(province);
		company1.setCompanyPhotos(cpDAO.selectListByCompanyId(company.getId()));
		return company1;
	}

}
