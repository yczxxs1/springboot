package com.netflix.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    
	/*@Autowired
	private DcService dcService;*/
	
	@Autowired
	private DcClient dcClient;

	@GetMapping("/consumer/hello")
	//@HystrixCommand(fallbackMethod = "fallback")
	public String dc() {
		//return dcService.getClient0Date();
	    return dcClient.consumer();
	}
	
	@GetMapping("/consumer/hi")
	public String dc1() {
		//return dcService.getClient0Date1();
		return dcClient.consumer1();
	}
	
	public String fallback(){
		return "fallback";
	}

	
}
