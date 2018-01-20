package com.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

@EnableSwagger2Doc
@SpringBootApplication
public class UavForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(UavForumApplication.class, args);
	}
}
