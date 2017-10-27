package com.google.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.VersionDAO;
import com.google.business.model.VersionEntity;
import com.google.business.service.VersionService;
import com.google.common.exception.ServiceException;



@Service
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionDAO versionDAO;

	@Override
	public VersionEntity getVersion(VersionEntity versionEntity) {
		// TODO Auto-generated method stub
		VersionEntity ve = versionDAO.selectVersionInfo(versionEntity);
		if (ve==null) {
			throw new ServiceException("查询出错！");
		}
		return ve;
	}

}
