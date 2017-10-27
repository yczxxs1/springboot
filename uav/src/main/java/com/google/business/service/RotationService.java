package com.google.business.service;

import java.util.List;

import com.google.business.model.RotationEntity;

public interface RotationService {
	List<RotationEntity> getOne(RotationEntity rotation);
}
