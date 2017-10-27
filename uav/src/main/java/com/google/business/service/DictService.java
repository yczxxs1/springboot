package com.google.business.service;

import java.util.List;

import com.google.business.model.DictEntity;

public interface DictService {
	List<DictEntity> queryDictList(String type);
}
