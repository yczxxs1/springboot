package com.google.business.service;

import java.util.Map;

public interface InquiryService {
	public void getDetial(String userId);
	public Map<String, Map<String,Object>> getList(String id);

}
