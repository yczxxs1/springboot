package com.google.business.dao;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.SmsValidateEntity;

@Mapper
public interface SmsDAO {
    int save(SmsValidateEntity smsValidateEntity);
    
    int update(SmsValidateEntity smsValidateEntity);
    
    SmsValidateEntity selectOne(SmsValidateEntity smsValidateEntity);
    
  
	
}
