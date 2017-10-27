package com.google.business.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.business.dao.FencePointDAO;
import com.google.business.dao.LocationInfoDAO;
import com.google.business.dao.MessageDAO;
import com.google.business.dao.UserDAO;
import com.google.business.model.FenceInfo2;
import com.google.business.model.FencePoint;
import com.google.business.model.LocationInfoEntity;
import com.google.business.model.MessageEntity;
import com.google.business.model.User;
import com.google.business.service.FencePointService;
import com.google.business.util.jpush.Extra;
import com.google.business.util.jpush.Push;
import com.google.common.webSocket.client.ClientWebsocket;



@Service
public class FencePointServiceImpl implements FencePointService {

	@Autowired
	private LocationInfoDAO locationDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private FencePointDAO fenceDAO;
	@Autowired
	private MessageDAO messageDAO;

	@Override
	public List<FenceInfo2> getFencePoint(String userId, Double latitude, Double longitude) {
		// TODO Auto-generated method stub
		LocationInfoEntity le = new LocationInfoEntity(longitude,latitude,new Date(),userId);// 发送websocket消息
		locationDAO.insertLocationInfo(le);
		User ue = new User();
		ue.setId(userId);
		ue = userDAO.selectOne(ue);
		le.setUser(ue);
		try {
			 ClientWebsocket clientEndPoint = new ClientWebsocket();
			 clientEndPoint.sendMessage(JSON.toJSONString(le));
			clientEndPoint.onClose();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		FencePoint fencePoint = new FencePoint();
		fencePoint.setLatitude(latitude);
		fencePoint.setLongitude(longitude);
		List<FenceInfo2> list = fenceDAO.selectPOI(fencePoint);
		if (list.size() > 0) {
			/*Double distance = list.get(0).getDistance();
			Integer height = list.get(0).getFenceHeight();
			String fenceName = list.get(0).getFenceName();*/
			MessageEntity messageEntity = new MessageEntity("提示", "请遵守《无锡市无人驾驶航空器管理办法》安全谨慎飞行！", "2", new Date(),
					"1", userId);
			messageEntity.setUrlFlag(1);
			messageDAO.insertMessage(messageEntity);
			Push.testSendPushByAlias("请遵守《无锡市无人驾驶航空器管理办法》安全谨慎飞行！", userId, new Extra().setMessageId(messageEntity.getId()).setUrlFlag(1));
		} else {
			MessageEntity messageEntity = new MessageEntity("提示", "请遵守《无锡市无人驾驶航空器管理办法》安全谨慎飞行！", "2", new Date(),
					"1", userId);
			messageEntity.setUrlFlag(1);
			messageDAO.insertMessage(messageEntity);
			Push.testSendPushByAlias("请遵守《无锡市无人驾驶航空器管理办法》安全谨慎飞行！", userId, new Extra().setMessageId(messageEntity.getId()).setUrlFlag(1));
		}
		return list;
	}

}
