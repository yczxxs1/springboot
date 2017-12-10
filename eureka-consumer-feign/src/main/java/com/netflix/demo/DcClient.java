package com.netflix.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client0")
public interface DcClient {
    @GetMapping("/hello")
    String consumer();
    
    @GetMapping("/hi")
    String consumer1();
}
