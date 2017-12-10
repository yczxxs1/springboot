package com.netflix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableFeignClients
@EnableHystrixDashboard
@EnableTurbine
@SpringCloudApplication
public class EurekaConsumerFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerFeignHystrixApplication.class, args);
	}
}
