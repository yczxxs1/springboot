package com.google.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.DictDAO;
import com.google.business.model.DictEntity;
import com.google.business.service.DictService;
import com.google.common.exception.ServiceException;

@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictDAO dictDAO;
	
	@Override
	public List<DictEntity> queryDictList(String type) {
		DictEntity dictEntity = new DictEntity();
		dictEntity.setType(type);
		List<DictEntity> dictlList = dictDAO.selectDictList(dictEntity);
		if (dictlList.size() == 0) {
			throw new ServiceException("未查询到数据！");
		} else {
			return dictlList;
		}
	}

}
