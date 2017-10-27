package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.RotationEntity;

@Mapper
public interface RotationDAO {
	List<RotationEntity> selectOne(RotationEntity rotation);
}
