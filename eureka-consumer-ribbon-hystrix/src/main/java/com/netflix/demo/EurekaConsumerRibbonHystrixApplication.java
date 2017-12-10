package com.netflix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/*@EnableHystrix
@EnableEurekaClient
@SpringBootApplication*/
@SpringCloudApplication
public class EurekaConsumerRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerRibbonHystrixApplication.class, args);
	}
}
