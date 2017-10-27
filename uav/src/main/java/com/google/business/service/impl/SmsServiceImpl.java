package com.google.business.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.SmsDAO;
import com.google.business.dao.UserDAO;
import com.google.business.model.SmsValidateEntity;
import com.google.business.model.User;
import com.google.business.service.SmsService;
import com.google.business.util.sms.ResponseEntity;
import com.google.business.util.sms.SendMsg;
import com.google.common.exception.ServiceException;

@Service
public class SmsServiceImpl implements SmsService {

	@Autowired
	private SmsDAO smsDAO;

	@Autowired
	private UserDAO userDAO;

	@Override
	public void saveCode(String mobile) throws Exception {
		// TODO Auto-generated method stub

		ResponseEntity re = SendMsg.sendMsg(mobile);
		SmsValidateEntity smsValidateEntity = new SmsValidateEntity();

		if ("100".equals(re.getStat())) {
			smsValidateEntity.setPhoneNumber(mobile);// 设置手机号
			String code = re.getRandomNum(); // 验证码
			Calendar cld = Calendar.getInstance();
			cld.setTime(new Date());
			cld.add(Calendar.MINUTE, +3);
			Date expireDate = cld.getTime(); // 到期时间
			if (smsDAO.selectOne(smsValidateEntity) == null) {// 是否是第一次校验，如果是第一次那么就新增否则更新
				smsValidateEntity.setCode(code);
				smsValidateEntity.setExpireDate(expireDate);
				smsDAO.save(smsValidateEntity); // 新增
			} else {
				smsValidateEntity.setCode(code);
				smsValidateEntity.setExpireDate(expireDate);
				smsDAO.update(smsValidateEntity); // 更新
			}
		} else {
			throw new ServiceException("获取手机验证码失败");

		}

	}

	@Override
	public void sendMsg(String mobile, String use) throws Exception {
		// TODO Auto-generated method stub
		User userinfoEntity = new User();
		// use 区分注册用 还是 忘记密码用 0是注册1忘记密码
		userinfoEntity.setUserMobile(mobile);
		if ("0".equals(use)) {
			if (userDAO.selectOne(userinfoEntity) == null) {
				saveCode(mobile);
			} else {
				throw new ServiceException("该手机号已被注册");
			}
		} else if ("1".equals(use)) {
			saveCode(mobile);
		}
	}
	
	@Override
	public void verifyCode(String mobile, String code) throws Exception {
		// TODO Auto-generated method stub
		SmsValidateEntity smsValidateEntity = new SmsValidateEntity();
		Date currentTime = new Date();// 当前时间
		smsValidateEntity.setPhoneNumber(mobile);// 手机号
		smsValidateEntity.setCode(code);// 验证码
		smsValidateEntity = smsDAO.selectOne(smsValidateEntity);
		if (smsValidateEntity == null) {
			throw new ServiceException("手机号或者验证码不正确！");
		} else {
			if (currentTime.before(smsValidateEntity.getExpireDate())) {

			} else {
				throw new ServiceException("验证码已过期，请重新获取！");

			}
		}
	}

}
