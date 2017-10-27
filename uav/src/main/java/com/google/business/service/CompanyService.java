package com.google.business.service;

import java.io.File;
import java.util.List;

import com.google.business.model.CompanyPhoto;
import com.google.business.model.Companys;

public interface CompanyService {
	
	public void saveOrUpdate(Companys company,List<File> files) throws Exception;
	
	public List<CompanyPhoto> getCompanyPhotoByCompanyId(String companyId);
	
	public Companys getCompanyDetail(String userId);

}
