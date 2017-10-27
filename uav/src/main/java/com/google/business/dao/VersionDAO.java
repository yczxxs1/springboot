package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.google.business.model.VersionEntity;

@Mapper
public interface VersionDAO {

    int insertVersionEntity(VersionEntity versionEntity);
    
    int deleteVersionEntity(VersionEntity versionEntity);
    
    int updateVersionEntity(VersionEntity versionEntity);
    
    List<VersionEntity> selectListVersionEntity(VersionEntity versionEntity);
 
    VersionEntity selectVersionInfo(VersionEntity versionEntity);
    
}