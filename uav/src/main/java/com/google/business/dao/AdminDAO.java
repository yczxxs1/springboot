package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.AdminEntity;

@Mapper
public interface AdminDAO {
		int insertAdmin(AdminEntity adminEntity);
		int updateAdmin(AdminEntity adminEntity);
		int deleteAdmin(AdminEntity adminEntity);
		List<AdminEntity> selectAdmin(AdminEntity adminEntity);
		AdminEntity selectOne(AdminEntity adminEntity);
}
