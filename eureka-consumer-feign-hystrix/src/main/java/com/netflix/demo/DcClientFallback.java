package com.netflix.demo;

import org.springframework.stereotype.Component;

@Component
public class DcClientFallback implements DcClient {

	@Override
	public String consumer() {
		// TODO Auto-generated method stub
		return "fallback";
	}

	@Override
	public String consumer1() {
		// TODO Auto-generated method stub
		return "fallback";
	}

    
}
