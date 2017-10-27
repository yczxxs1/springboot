package com.google.business.service;

import java.io.File;
import java.util.List;

import com.google.business.model.User;

public interface UserService {

	public User login(String userName,String password);
	public void register(User user);
	public void update(User user);
	public void delete(String userId);
    public void forget(String mobile,String code,String password);
    public String uploadAvatar(String userId,File file) throws Exception;
    public User getUser(String userId);
    public void updatePassword(String oldPassword,String newPassword,String userId);
    /**
	 * <p>web端接口：获取用户列表
	 */
    public List<User> getUserList(User user);
    public User getUserDetail(String userId);

}

