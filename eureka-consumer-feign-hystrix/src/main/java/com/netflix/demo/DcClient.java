package com.netflix.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="eureka-client0", fallback = DcClientFallback.class)
public interface DcClient {
    @GetMapping("/hello")
    String consumer();
    
    @GetMapping("/hi")
    String consumer1();
    
   /* static class HystrixClientFallback implements DcClient {

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
    	
    }*/
      
}
