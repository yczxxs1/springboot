package com.google.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.business.dao.PersonDAO;
import com.google.business.dao.UserDAO;
import com.google.business.model.Person;
import com.google.business.model.User;
import com.google.business.service.PersonService;
import com.google.common.exception.ServiceException;
@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;
	@Autowired
	private UserDAO  userDAO;
	
	@Transactional
	@Override
	public void saveOrUpdate(Person person,String areaId) {
		//校验userId
		String userId=person.getUserId();
		if(userId==null){
			throw new ServiceException("非法！");
		}
		//更新区域id和用户状态
		User user0=userDAO.selectByPrimaryKey(userId);
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
		//更新或保存个人信息
		Person person1=new Person();
		person1.setUserId(person.getUserId());
		Person person2=personDAO.selectOne(person1);
		if(person2==null){
			personDAO.insertSelective(person);
		}else{
			person.setId(person2.getId());
			personDAO.updateByPrimaryKey(person);
		}
		
	}
	
}
