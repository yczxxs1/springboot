package com.google.business.service;

import java.util.List;

import com.google.business.model.AdminEntity;

public interface AdminService {
	void createAdmin(AdminEntity adminEntity);
	void delAdminBatch(List<String> list);
	void updateAdmin(AdminEntity adminEntity);
	List<AdminEntity> getAdminList(AdminEntity adminEntity);
	AdminEntity getDetail(AdminEntity adminEntity);
	AdminEntity login(String name,String password);
	void resetPasswordBatch(List<String> list);
	void editPassword(String oldPassword,String newPassword,String userId);
}
