package com.google.business.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.google.business.dto.UserDTO;
import com.google.business.model.User;

@Mapper
public interface UserDAO {
	int deleteByPrimaryKey(String id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);

	List<User> selectList(UserDTO userDTO);

	User selectOne(User user);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	User selectListUserinfoEntity(User user);
	
	int updateUserinfoEntity(User user);
	
	int selectUserCount(User user);
}