package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.model.Person;
import com.google.business.service.PersonService;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Person")
@Api(description="个人信息相关操作")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@ApiOperation(value="完善个人信息")
	@PostMapping("/savePerson")
	public Result savePerson(Person person,@RequestParam String areaId){
		personService.saveOrUpdate(person,areaId);
		return ResultUtil.success();
	}
}
