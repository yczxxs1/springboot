package com.google.business.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.business.dao.SaleInfoDAO;
import com.google.business.dao.SaleinfoPhotoDAO;
import com.google.business.dao.UavDAO;
import com.google.business.dao.UavHistoryDAO;
import com.google.business.model.SaleInfoEntity;
import com.google.business.model.SaleinfoPhotoEntity;
import com.google.business.model.UavEntity;
import com.google.business.model.UavHistoryEntity;
import com.google.business.service.SaleInfoService;
import com.google.business.util.fastDFS.FastDFSFileUtils;
import com.google.common.exception.ServiceException;

@Service
public class SaleInfoServiceImpl implements SaleInfoService {

	@Autowired
	private SaleInfoDAO saleInfoDAO;
	@Autowired
	private UavDAO uavDAO;
	@Autowired
	private UavHistoryDAO uavHistoryDAO;
	@Autowired
	private SaleinfoPhotoDAO saleinfoPhotoDAO;

	@Override
	@Transactional
	public void addSaleInfo(SaleInfoEntity saleInfo, List<File> files) throws Exception {
		// 查询sn对应的无人机的状态
		try {
			UavEntity uav = new UavEntity();
			uav.setSnNumber(saleInfo.getSn());
			uav = uavDAO.selectUavOne(uav);
			if (uav != null) {
				saleInfo.setRegstatus("1");
				if("2".equals(uav.getReview())){
					saleInfo.setRegstatus("1");
				}else{
					saleInfo.setRegstatus("0");
				}
			} else {
				saleInfo.setRegstatus("0");
			}
			saleInfoDAO.insertSelective(saleInfo);
			if (files != null) {
				for (File file : files) {
					String photoUrl = FastDFSFileUtils.uploadFileToDfs(file);
					SaleinfoPhotoEntity upe = new SaleinfoPhotoEntity();
					upe.setSaleinfoId(saleInfo.getId());
					upe.setSaleinfoPhoto(photoUrl);
					saleinfoPhotoDAO.insertSelective(upe);
				}
			}
			// 生成历史记录 snNumber status=2 saleId
			UavHistoryEntity uavHistory = new UavHistoryEntity();
			uavHistory.setSnNumber(saleInfo.getSn());
			uavHistory.setStatus("2");
			uavHistory.setSaleId(saleInfo.getId());
			uavHistoryDAO.insertSelective(uavHistory);
		} finally {
			// TODO: handle finally clause
			for(File file:files){
				file.delete();
			}
		}
		
	}

	@Override
	public int saleInfoCount(SaleInfoEntity saleInfo) {
		if(saleInfo.getVendorid()==null){
			throw new ServiceException("非法！");
		}
		int count = saleInfoDAO.selectSaleInfo_count(saleInfo);
		return count;
	}

	@Override
	public void checkSn(SaleInfoEntity saleInfo) {
		List<SaleInfoEntity> list = saleInfoDAO.selectSaleInfo(saleInfo);
		if (list.size() > 0) {
			// 表中存在此sn编号的信息 返回失败
			throw new ServiceException("此sn码已被登记！");
		} else {
			// 不存在
		}
	}

	@Override
	public SaleInfoEntity saleInfodetail(SaleInfoEntity saleInfo) {
		SaleInfoEntity saleModel =saleInfoDAO.selectSaleInfoOne(saleInfo);
		if(saleModel==null){
			throw new ServiceException("销售不存在！");
		}else{
			SaleinfoPhotoEntity saleinfoPhotoEntity=new SaleinfoPhotoEntity();
			saleinfoPhotoEntity.setSaleinfoId(saleInfo.getId());
			List<SaleinfoPhotoEntity> saleinfoPhoto=saleinfoPhotoDAO.selectDetail(saleinfoPhotoEntity);
		  saleModel.setSaleinfoPhotoEntity(saleinfoPhoto);
		}
		
		return  saleModel;
	}

	@Override
	public List<SaleInfoEntity> saleInfolist(SaleInfoEntity saleInfo) {
		if(saleInfo.getVendorid()==null){
			throw new ServiceException("非法！");
		}
		saleInfo.setRegstatus("0");
		List<SaleInfoEntity> list = saleInfoDAO.selectSaleInfo(saleInfo);
		for (SaleInfoEntity se : list) {
			SaleinfoPhotoEntity spe = new SaleinfoPhotoEntity();
            spe.setSaleinfoId(se.getId());
			List<SaleinfoPhotoEntity> list1 = saleinfoPhotoDAO.selectDetail(spe);
			se.setSaleinfoPhotoEntity(list1);
			}
		return list;
	}

	@Override
	public List<SaleInfoEntity> saleInfolistByareaId(SaleInfoEntity saleInfo) {
		// 查询区域内 userType为1（单位）的所有记录的id等于saleinfo表中的VENDORID的记录
		List<SaleInfoEntity> list = saleInfoDAO.getSaleInfoByAreaId(saleInfo);
		return list;
	}

}
