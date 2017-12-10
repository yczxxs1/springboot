package com.netflix.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	@GetMapping("/hello")
	public String helloWorld(){
		return "hello netflix!";
	}
	
	@GetMapping("/hi")
	public String hi(){
		return "hi netflix!";
	}

}
