package com.google.business.service;

import java.io.File;
import java.util.List;

import com.google.business.model.SaleInfoEntity;

public interface SaleInfoService {
	public void addSaleInfo(SaleInfoEntity saleInfo,List<File> list) throws Exception; 
	public int saleInfoCount(SaleInfoEntity saleInfo);
	public void checkSn(SaleInfoEntity saleInfo);
	public SaleInfoEntity saleInfodetail(SaleInfoEntity saleInfo);
	public List<SaleInfoEntity> saleInfolist(SaleInfoEntity saleInfo);
	public List<SaleInfoEntity> saleInfolistByareaId(SaleInfoEntity saleInfo);
}
