package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.google.business.model.LicensePhotoEntity;

@Mapper
public interface LicensePhotoDAO{

    int insertSelective(LicensePhotoEntity licensePhotoEntity);
  
    int deleteByPrimaryKey(LicensePhotoEntity licensePhotoEntity);
    
    int updateByPrimaryKeySelective(LicensePhotoEntity licensePhotoEntity);
    
    List<LicensePhotoEntity> selectLicensePhotoList(LicensePhotoEntity licensePhotoEntity);
   
    LicensePhotoEntity selectLicensePhotoOne(LicensePhotoEntity licensePhotoEntity);
    
    LicensePhotoEntity selectLicensePhotoFirst(String licenseId);
}