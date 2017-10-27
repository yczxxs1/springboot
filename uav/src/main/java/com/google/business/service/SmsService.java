package com.google.business.service;

public interface SmsService {
	
	
    /**
     * @param mobile
     * @throws Exception
     * <p>通用 发送验证码并保存 不开放
     */
    public void saveCode(String mobile) throws Exception;
    
    //
    
    
    /**
     * @param mobile
     * @param use
     * @throws Exception
     * 针对注册和修改密码 开放
     */
    public void sendMsg(String mobile,String use) throws Exception;
    
    
    public void verifyCode(String mobile,String code) throws Exception;
}
