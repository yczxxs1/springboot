package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.SaleInfoEntity;

@Mapper
public interface SaleInfoDAO {
    int insertSelective(SaleInfoEntity saleInfo);
    
    int deleteSaleInfo(SaleInfoEntity saleInfo);
    
	List<SaleInfoEntity> selectSaleInfo(SaleInfoEntity saleInfo);
	
	SaleInfoEntity selectSaleInfoOne(SaleInfoEntity saleInfo);
	
	int selectSaleInfo_count(SaleInfoEntity saleInfo);
	
	List<SaleInfoEntity> getSaleInfoByAreaId(SaleInfoEntity saleInfo);
	
	void updateSaleInfoBySn(SaleInfoEntity saleInfo);
    //SaleInfoEntity selectSaleInfo(SaleInfoEntity saleEntity);
}