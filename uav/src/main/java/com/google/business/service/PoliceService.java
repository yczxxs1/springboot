package com.google.business.service;

import com.google.business.model.Police;

public interface PoliceService {
	public void saveOrUpdatePolice(Police police,String areaId);
	
	public Police getPoliceDetail(String userId);
}
