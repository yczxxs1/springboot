package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.google.business.model.LicenseTypeEntity;

@Mapper
public interface LicenseTypeDAO {
    int insertSelective(LicenseTypeEntity licenseTypeEntity);
    
    int deleteByPrimaryKey(LicenseTypeEntity licenseTypeEntity);
    
    int updateByPrimaryKeySelective(LicenseTypeEntity licenseTypeEntity);
    
    List<LicenseTypeEntity> selectLicenseTypeList(LicenseTypeEntity licenseTypeEntity);
    
    LicenseTypeEntity selectLicenseTypeOne(LicenseTypeEntity licenseTypeEntity);
}