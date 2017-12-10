package com.netflix.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DcServiceImpl implements DcService{

	@Autowired
	DcClient dcClient;
	@Override
	public String getClient0Date() {
		// TODO Auto-generated method stub
		return dcClient.consumer()+"aaaa";
	}
	@Override
	public String getClient0Date1() {
		// TODO Auto-generated method stub
		return dcClient.consumer()+dcClient.consumer1();
	}

}
