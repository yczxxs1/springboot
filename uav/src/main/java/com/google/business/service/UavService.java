package com.google.business.service;

import java.io.File;
import java.util.List;

import com.google.business.model.UavEntity;
import com.google.business.model.UavTransferEntity;

public interface UavService {
	public List<UavEntity> getUavs(UavEntity uav);
	public UavEntity queryUavDetail(UavEntity uav);
	public void deleteUav(UavEntity uav);
	public void deleteUavBatch(List<String> list);
	public String checkOutSnNumber(UavEntity uav);
	public void updateWriteOffUAV(UavEntity uav);
	public void transferUAV(String status, String belongId, UavTransferEntity uavTransfer);
	public void createUavInfo(UavEntity uavEntity,List<File> list) throws Exception;
	public String gainSNnumber();
	public void  snEdit(String sn,String id);
	public List<UavEntity> getUavList(UavEntity uav);
	public void review(UavEntity uav);
	public int getUavCount(UavEntity uav);
	public void insertData() throws Exception;
}
