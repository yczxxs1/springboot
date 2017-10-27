package com.google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.didispace.swagger.EnableSwagger2Doc;


@EnableSwagger2Doc
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		SpringApplication.run(Application.class, args);

	}
	

}
