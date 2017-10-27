package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.google.business.model.LicenseEntity;


@Mapper
public interface LicenseDAO {
   
    int insertSelective(LicenseEntity licenseEntity);
    
    int deleteByPrimaryKey(LicenseEntity licenseEntity);
    
    int deleteByUserId(LicenseEntity licenseEntity);
    
    int updateByPrimaryKeySelective(LicenseEntity licenseEntity);
   
    List<LicenseEntity> selectLicenseList(LicenseEntity licenseEntity);
  
    LicenseEntity selectLicenseOne(LicenseEntity licenseEntity);
    
    int selectLicenseList_count(LicenseEntity licenseEntity);
    
    List<LicenseEntity> selectLienseListByAreaId(@Param("le")LicenseEntity licenseEntity,@Param("areaId") String[] areaId);
    
    LicenseEntity selectByPrimaryKey(LicenseEntity licenseEntity);
    
}