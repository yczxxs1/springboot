package com.google.business.service;

import java.io.File;
import java.util.List;

import com.google.business.model.LicenseEntity;
import com.google.business.model.LicenseTypeEntity;

public interface LicenseService {
	/**
	 * 
	 * @param licenseEntity
	 */
	void saveOrUpdate(LicenseEntity licenseEntity,List<File> files) throws Exception;
	
	void deleteSelective(LicenseEntity licenseEntity);
	
	void deleteBatch(List<String> list);
	
	void updateSelective(LicenseEntity licenseEntity);
	
	List<LicenseEntity> getLicenseList(LicenseEntity licenseEntity);
	
	LicenseEntity getLicenseList_Count(LicenseEntity licenseEntity);
	
	List<LicenseTypeEntity> getLicenseType(LicenseTypeEntity licenseTypeEntity);

	void review(LicenseEntity licenseEntity);
	
	List<LicenseEntity> getLicenseListByAreaId(LicenseEntity licenseEntity);
}
