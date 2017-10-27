package com.google.business.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.business.dao.AreaDAO;
import com.google.business.dao.CityDAO;
import com.google.business.dao.LicenseDAO;
import com.google.business.dao.MessageDAO;
import com.google.business.dao.ProvinceDAO;
import com.google.business.dao.SaleInfoDAO;
import com.google.business.dao.UavDAO;
import com.google.business.dao.UavHistoryDAO;
import com.google.business.dao.UavPhotoDAO;
import com.google.business.dao.UavTransferDAO;
import com.google.business.dao.UserDAO;
import com.google.business.model.Area;
import com.google.business.model.LicenseEntity;
import com.google.business.model.MessageEntity;
import com.google.business.model.SaleInfoEntity;
import com.google.business.model.UavEntity;
import com.google.business.model.UavHistoryEntity;
import com.google.business.model.UavPhotoEntity;
import com.google.business.model.UavTransferEntity;
import com.google.business.model.User;
import com.google.business.service.UavService;
import com.google.business.util.fastDFS.FastDFSFileUtils;
import com.google.business.util.jpush.Extra;
import com.google.business.util.jpush.Push;
import com.google.common.exception.ServiceException;

@Service
public class UavServiceImpl implements UavService {

	@Autowired
	private UavDAO uavDAO;

	@Autowired
	private UavPhotoDAO uavPhotoDAO;

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UavHistoryDAO uavHistoryDAO;

	@Autowired
	private MessageDAO messageDAO;

	@Autowired
	private UavTransferDAO uavTransferDAO;

	@Autowired
	private LicenseDAO licenseDAO;

	@Autowired
	private ProvinceDAO provinceDAO;

	@Autowired
	private CityDAO cityDAO;

	@Autowired
	private AreaDAO areaDAO;

	@Autowired
	private SaleInfoDAO saleInfoDAO;

	@Override
	public String checkOutSnNumber(UavEntity uav) {
		UavEntity snNumber = uavDAO.selectUavOne(uav);
		if (snNumber != null) {
			String status = snNumber.getStatus();
			if ("0".equals(status)) {
				return "此无人机已被他人注销过！";
			}
			if ("1".equals(status)) {
				throw new ServiceException("此无人机已被他人登记！");
			}
			if ("9".equals(status)) {
				return "此无人机已被他人转让过!";
			} else {
				throw new ServiceException("如果你遇到这句话，你就是神人！");
			}
		} else {
			return "检验成功！";
		}
	}

	@Override
	@Transactional
	public List<UavEntity> getUavs(UavEntity uav) {
		// TODO Auto-generated method stub
		if (uav.getBelongId() == null) {
			throw new ServiceException("非法！");
		}
		List<UavEntity> list = uavDAO.selectUavList(uav);
		// 无人机列表图片默认显示无人机模型图片
		// 如果无人机有图片，无人机模型无图片泽显示无人机第一张图片
		for (UavEntity ue : list) {
			// UavModelEntity uavModelEntity = new UavModelEntity();
			// uavModelEntity.setId(ue.getModelId());
			// UavModelEntity ume =
			// uavModelDAO.selectUavModelOne(uavModelEntity);
			UavPhotoEntity upe = uavPhotoDAO.selectUavPhotoFirst(ue.getId());
			// if (ume != null &&
			// StringUtils.isNotBlank(ume.getProductPhotoUrl())) {
			// ue.setPhotoUrl(ume.getProductPhotoUrl());
			// } else if (upe != null) {
			if (upe == null) {

			} else {
				ue.setPhotoUrl(upe.getPhotoUrl());
			}
			// } else {
			// ue.setPhotoUrl("");
			// }
		}
		return list;
	}

	@Override
	public UavEntity queryUavDetail(UavEntity uav) {
		UavEntity uEntity = uavDAO.selectUavOneDetail(uav);
		return uEntity;
	}

	@Override
	@Transactional
	public void deleteUav(UavEntity uav) {
		UavEntity uavEntity1 = uavDAO.selectUavOne(uav);
		if (uavEntity1 == null) {

			throw new ServiceException("参数错误！");
		}
		String review = uavEntity1.getReview();
		if ("2".equals(review)) {
			throw new ServiceException("审核通过后禁止删除！");
		} else {
			uavDAO.deleteByPrimaryKey(uav);
			// 删除图片
			// uavPhotoDAO.deleteByUavId(id);
			UavPhotoEntity uavPhotoEntity = new UavPhotoEntity();
			String id = uav.getId();
			uavPhotoEntity.setUavId(id);
			List<UavPhotoEntity> ulpeList = uavPhotoDAO.selectUavPhotoList(uavPhotoEntity);
			for (UavPhotoEntity upe : ulpeList) {
				uavPhotoDAO.deleteByPrimaryKey(upe);
				FastDFSFileUtils.deleteFileToDfs(upe.getPhotoUrl());
			}
		}
	}

	@Override
	@Transactional // 注销
	public void updateWriteOffUAV(UavEntity uav) {
		// 更新状态为0
		uavDAO.updateByPrimaryKeySelective(uav);
		uav = uavDAO.selectUavOne(uav);
		// 判断该用户 是否存在一个 状态为正常并且审核通过的无人机或者状态为正常并且审核通过的无人机
		// 如果存在，则不改变该用户的认证状态，如果不存在，则改变改用的认证状态为未认证（2）
		UavEntity uav1 = new UavEntity();
		uav1.setStatus("1");
		uav1.setReview("2");
		uav1.setBelongId(uav.getBelongId());
		int count1 = uavDAO.selectUavList_count(uav1);
		LicenseEntity license = new LicenseEntity();
		license.setUserId(uav.getBelongId());
		license.setLicenseStatus("1");
		license.setReview("2");
		int count2 = licenseDAO.selectLicenseList_count(license);
		if (count1 >= 1 || count2 >= 1) {
			// 符合认证条件，不做改变
		} else {
			// 不符合认账条件，将users表中的userstatus改为2
			User user = new User();
			user.setId(uav.getBelongId());
			user.setUserStatus("2");
			userDAO.updateByPrimaryKeySelective(user);
		}
		UavHistoryEntity uavHistory = new UavHistoryEntity();
		uavHistory.setSnNumber(uav.getSnNumber());
		uavHistory.setStatus(uav.getStatus());
		uavHistory.setHistoryBelongId(uav.getBelongId());
		uavHistoryDAO.insertSelective(uavHistory);
	}

	@Override
	@Transactional // 新增
	public void createUavInfo(UavEntity uavEntity, List<File> files) throws Exception {
		try {
			if (uavEntity.getBelongId() == null) {
				throw new ServiceException("非法！");
			}
			User user = new User();
			user.setId(uavEntity.getBelongId());
			user = userDAO.selectOne(user);
			if ("0".equals(user.getUserStatus())) {
				throw new ServiceException("请先完善个人信息！");
			}
			String uavId = uavEntity.getId();
			if ("".equals(uavId) || uavId == null) {
				UavEntity uavEntity0 = new UavEntity();
				uavEntity0.setSnNumber(uavEntity.getSnNumber());
				UavEntity snNumber = uavDAO.selectUavBySnNumber(uavEntity0);
				if (snNumber != null) {
					String status = snNumber.getStatus();
					String review = snNumber.getReview();
					if ("1".equals(status) && !"1".equals(review)) {
						throw new ServiceException("此无人机已被他人登记！");
					} else {
						// 删除库里sn相同的记录(有就删 没有就不删)
						UavEntity uav = new UavEntity();
						uav.setSnNumber(uavEntity.getSnNumber());
						uavDAO.deleteBySnNumber(uav);
						// 新增无人机
						uavDAO.insertSelective(uavEntity);
					}
				} else {
					// 新增无人机
					uavDAO.insertSelective(uavEntity);
				}
			} else {
				// 编辑
				UavEntity uavEntity0 = new UavEntity();
				uavEntity0.setSnNumber(uavEntity.getSnNumber());
				UavEntity snNumber = uavDAO.selectUavBySnNumber(uavEntity0);
				if (snNumber != null) {
					String status = snNumber.getStatus();
					String review = snNumber.getReview();
					if ("1".equals(status) && !"1".equals(review)) {
						throw new ServiceException("此无人机已被他人登记！");
					} else {
						uavEntity.setId(uavId);
						uavEntity.setReview("0");
						uavDAO.updateByPrimaryKeySelective(uavEntity);
						UavPhotoEntity upe = new UavPhotoEntity();
						upe.setUavId(uavId);
						List<UavPhotoEntity> list = uavPhotoDAO.selectUavPhotoList(upe);
						// 删除文件服务器上的图片
						for (UavPhotoEntity up : list) {
							FastDFSFileUtils.deleteFileToDfs(up.getPhotoUrl());
							// 删库
							uavPhotoDAO.deleteByPrimaryKey(up);
						}
					}
				} else {
					uavEntity.setId(uavId);
					uavEntity.setReview("0");
					uavDAO.updateByPrimaryKeySelective(uavEntity);
					UavPhotoEntity upe = new UavPhotoEntity();
					upe.setUavId(uavId);
					List<UavPhotoEntity> list = uavPhotoDAO.selectUavPhotoList(upe);
					// 删除文件服务器上的图片
					for (UavPhotoEntity up : list) {
						FastDFSFileUtils.deleteFileToDfs(up.getPhotoUrl());
						// 删库
						uavPhotoDAO.deleteByPrimaryKey(up);
					}
				}

			}
			if (files != null) {
				for (File file : files) {
					String photoUrl = FastDFSFileUtils.uploadFileToDfs(file);
					UavPhotoEntity upe = new UavPhotoEntity();
					upe.setUavId(uavEntity.getId());
					upe.setPhotoUrl(photoUrl);
					upe.setUserId(uavEntity.getBelongId());
					upe.setCreateDate(new Date());
					uavPhotoDAO.insertSelective(upe);
				}
			}

		} finally {
			// TODO: handle finally clause
			for (File file : files) {
				file.delete();
			}
		}

	}

	@Override // 生成SN编号
	public String gainSNnumber() {
		String SNnumber;
		UavEntity uav = new UavEntity();
		do {
			// 左补0至6位
			SNnumber = "WXUAVZ" + String.format("%06d", RandomUtils.nextInt(000000, 999999));
			uav.setSnNumber(SNnumber);
			uav = uavDAO.selectUavOne(uav);
		} while (uav != null);
		return SNnumber;
	}

	@Override // 编辑SN编号
	public void snEdit(String sn, String id) {
		// TODO Auto-generated method stub
		UavEntity uav = new UavEntity();
		uav.setSnNumber(sn);
		UavEntity snNumber = uavDAO.selectUavOne(uav);
		if (snNumber == null) {
			uav.setId(id);
			int snNumber1 = uavDAO.updateByPrimaryKeySelective(uav);
			if (snNumber1 == 0) {
				throw new ServiceException("修改失败！");
			}
		} else {
			throw new ServiceException("该SN编号已存在！");
		}
	}

	@Override
	public List<UavEntity> getUavList(UavEntity uav) {
		// TODO Auto-generated method stub
		String areaIds=uav.getAreaId();
		String[] areaId=null;
		if(!StringUtils.isEmpty(areaIds)){
			areaId=areaIds.split(",");
		}
		return uavDAO.selectUavListByArea(uav, areaId);
	}

	@Override
	@Transactional
	public void review(UavEntity uavEntity) {
		// TODO Auto-generated method stub

		String review = uavEntity.getReview();
		String belongId = uavEntity.getBelongId();// 获取userId
		UavEntity uav = uavDAO.selectUavOne(uavEntity);
		String content = " ";
		MessageEntity me = null;
		// 校验审核状态
		UavEntity uav1 = new UavEntity();
		uav1.setId(uavEntity.getId());
		uav1 = uavDAO.selectUavOne(uav1);
		if (!"2".equals(uav1.getReview())) {
			 if ("2".equals(review)) {
						// 变更用户状态
						if (userDAO.selectByPrimaryKey(belongId) != null) {
							User user = new User();
							user.setUserStatus("1");
							user.setId(belongId);
							userDAO.updateByPrimaryKeySelective(user);
						}
						// 判断销售记录中有没有这个无人机的销售记录
						// 有的话改销售记录中的状态为1 没有则不动
						String sn = uav.getSnNumber();
						SaleInfoEntity saleinfo = new SaleInfoEntity();
						saleinfo.setSn(sn);
						saleinfo = saleInfoDAO.selectSaleInfoOne(saleinfo);

						if (saleinfo == null) {

						} else {
							SaleInfoEntity saleinfo1 = new SaleInfoEntity();
							saleinfo1.setSn(sn);
							saleinfo1.setRegstatus("1");
							saleInfoDAO.updateSaleInfoBySn(saleinfo1);
						}

						me = new MessageEntity("无人机审核通过！", content, "2", new Date(), "1", belongId);
						messageDAO.insertMessage(me);
						// 推送
						Push.testSendPushByAlias("无人机审核通过", belongId, new Extra().setMessageId(me.getId()));
						
						
				} else if ("1".equals(review)) {
					content="理由:" + uavEntity.getReviewReason();
					if(!"".equals(uavEntity.getReviewRemark())){
						content=content+"\n"+"备注:"+uavEntity.getReviewRemark();
					}
					me = new MessageEntity("无人机审核不通过！", content, "2", new Date(), "1", belongId);
					messageDAO.insertMessage(me);
					// 推送
					Push.testSendPushByAlias("无人机审核不通过", belongId, new Extra().setMessageId(me.getId()));
				} else {
					throw new ServiceException("review非法！");
				}
		}
		
		UavHistoryEntity uavHistory = new UavHistoryEntity();
		UavEntity uavEntity1 = new UavEntity();
		uavEntity1 = uavDAO.selectUavOne(uavEntity);
		uavHistory.setSnNumber(uavEntity1.getSnNumber());
		uavHistory.setStatus("1");
		uavHistory.setHistoryBelongId(uavEntity1.getBelongId());
		uavHistoryDAO.insertSelective(uavHistory);
		uavDAO.updateByPrimaryKeySelective(uavEntity);
		
	}

	@Override
	@Transactional
	public void transferUAV(String status, String belongId, UavTransferEntity uavTransfer) {
		String snNumber = uavTransfer.getSnNumber();
		UavEntity uav = new UavEntity();
		uav.setSnNumber(snNumber);
		// 根据sn编号查询uav
		uav = uavDAO.selectUavOne(uav);
		String id = uav.getId();
		UavEntity uav1 = new UavEntity();
		uav1.setId(id);
		uav1.setStatus(status);
		// 根据id和状态更新uav
		uavDAO.updateByPrimaryKeySelective(uav1);
		User user = new User();
		user.setId(belongId);
		User user1 = userDAO.selectOne(user);
		uavTransfer.setOwnerName(user1.getNikeName());
		uavTransfer.setOwnerCard(user1.getCertNumber());
		// 保存转让信息到转让表中
		uavTransferDAO.insertSelective(uavTransfer);
		// 判断该用户 是否存在一个 状态为正常并且审核通过的无人机或者状态为正常并且审核通过的无人机
		// 如果存在，则不改变该用户的认证状态，如果不存在，则改变改用的认证状态为未认证（2）
		UavEntity uav2 = new UavEntity();
		uav2.setStatus("1");
		uav2.setReview("2");
		uav2.setBelongId(belongId);
		int count1 = uavDAO.selectUavList_count(uav2);
		LicenseEntity license = new LicenseEntity();
		license.setUserId(belongId);
		license.setLicenseStatus("1");
		license.setReview("2");
		int count2 = licenseDAO.selectLicenseList_count(license);
		if (count1 >= 1 || count2 >= 1) {
			// 符合认证条件，不做改变
		} else {
			// 不符合认账条件，将users表中的userstatus改为2
			User user2 = new User();
			user2.setId(belongId);
			user2.setUserStatus("2");
			userDAO.updateByPrimaryKeySelective(user2);
		}
		// 生成更新状态记录到历史表
		UavHistoryEntity uavHistory = new UavHistoryEntity();
		// 获取刚才转让信息表中生成的id
		uavHistory.setTransferId(uavTransfer.getId());
		uavHistory.setSnNumber(snNumber);
		uavHistory.setStatus(status);
		uavHistoryDAO.insertSelective(uavHistory);
	}

	@Override
	public int getUavCount(UavEntity uav) {
		int count = uavDAO.selectUavList_count(uav);
		return count;
	}

	@Override
	@Transactional
	public void deleteUavBatch(List<String> list) {
		// TODO Auto-generated method stub
		for(String uavId:list){
			UavEntity uav=new UavEntity();
			uav.setId(uavId);
			uavDAO.deleteByPrimaryKey(uav);
			// 删除图片
			// uavPhotoDAO.deleteByUavId(id);
			UavPhotoEntity uavPhotoEntity = new UavPhotoEntity();
			String id = uav.getId();
			uavPhotoEntity.setUavId(id);
			List<UavPhotoEntity> ulpeList = uavPhotoDAO.selectUavPhotoList(uavPhotoEntity);
			for (UavPhotoEntity upe : ulpeList) {
				uavPhotoDAO.deleteByPrimaryKey(upe);
				//FastDFSFileUtils.deleteFileToDfs(upe.getPhotoUrl());
			}
		}
		
		
	}
	
	@Override
	public void insertData() throws Exception {
		// String str = "北京市 北京市 东城区";
		// String regex = "^(\\S)+";
		// Pattern p = Pattern.compile(regex);
		// Matcher m = p.matcher(str);
		// while (m.find()) {
		// System.out.println(m.group(0));
		// }
		FileReader reader = new FileReader("E://省市区1.dat");
		BufferedReader br = new BufferedReader(reader);
		FileWriter writer = new FileWriter("E://省市区.dat");
		BufferedWriter bw = new BufferedWriter(writer);
		String sheng = "";
		int n = 371;
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");
			String str = null;
			String b = "";
			String d = "";
			String aa = "";
			String bb = "";
			while ((str = br.readLine()) != null) {
				String[] c = str.split("(\\s)+");
				// 判断非中文
				// String a = "[^\\u4e00-\\u9fa5]+";
				// str = str.replaceAll(a, " ");
				String regex = "[^\\u4e00-\\u9fa5]+";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(c[1]);
				while (m.find()) {
					// b 就是省级编号:province_id 父级id
					b = m.group(0);
				}

				regex = "[^\\\\u4e00-\\\\u9fa5]+";
				p = Pattern.compile(regex);
				m = p.matcher(c[1]);
				while (m.find()) {
					// d 就是省级名称:province_name
					d = m.group(0);
				}

				regex = "[^\\u4e00-\\u9fa5]+";
				p = Pattern.compile(regex);
				m = p.matcher(c[2]);
				while (m.find()) {
					// 市级编号
					aa = m.group(0);
				}

				regex = "[^\\\\u4e00-\\\\u9fa5]+";
				p = Pattern.compile(regex);
				m = p.matcher(c[2]);
				while (m.find()) {
					// 市级名称
					bb = m.group(0);
				}

				Area area = new Area();
				area.setAreaFatherId(b);
				area.setAreaId(aa);
				area.setAreaName(bb);
				if (sheng.equals(bb)) {

				} else {
					sheng = bb;
					areaDAO.insert(area);
				}
				// Sy
				// if(sheng.equals(c[2])){
				// //一样则不变
				// c[2] = c[2] + n;
				// }else{
				// //不一样则变
				// n++;
				// sheng = c[2];
				// c[2] = c[2] + n;
				// }
				// str = c[0]+ " " + c[1] + " " + c[2];

				// System.out.println(str);
				// String regex = "^(\\S)+";
				// Pattern p = Pattern.compile(regex);
				// Matcher m = p.matcher(str);
				// System.out.println(1);
				// while(m.find()){
				// b = m.group(0);
				// }
				// System.out.println(2);
				// if(sheng.equals(b)){
				// //如果一样
				// System.out.println(3);
				// str = str.replaceAll(regex, b+n);
				// }else{
				// //如果不一样
				// System.out.println(4);
				// n++;
				// sheng = b;
				// str = str.replaceAll(regex, b+n);
				// }
				// sb.append(str + "/n");
				// bw.write(str);
				// bw.newLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
			reader.close();
			bw.close();
			writer.close();
		}
	}

	public ProvinceDAO getProvinceDAO() {
		return provinceDAO;
	}

	public void setProvinceDAO(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}

	public CityDAO getCityDAO() {
		return cityDAO;
	}

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	
}
