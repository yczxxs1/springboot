package com.google.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.business.model.Emp;
import com.google.business.model.Emp.LOGIN;
import com.google.business.service.EmpService;
import com.google.common.exception.ServiceException;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

@RestController
@RequestMapping("emp")
public class EmpController {

	@Autowired
	private EmpService empService;

	@GetMapping("/list")
	public Result getEmps(Emp emp,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		PageInfo<Emp> pageInfo = new PageInfo<Emp>(empService.getEmpList(emp));
		return ResultUtil.success(pageInfo.getList());
	}
	
	@GetMapping("/{id}")
	public Emp getEmp(@PathVariable Integer id) {
		throw new ServiceException("fhg");
		/*Emp emp=new Emp();
		emp.setEmpno(id);*/
		/*return empService.getEmp(emp);*/
		
	}
	
	
	@PostMapping("/login")
	public Result login(@Validated(LOGIN.class)@RequestBody Emp emp) {
		return ResultUtil.success(empService.login(emp));
		
	}
	
	@PostMapping
	public Result saveEmp(Emp emp){
		return ResultUtil.success(empService.save(emp));
	}
	
	@PutMapping("/{id}")
	public Result updateEmp(@PathVariable Integer id){
		return ResultUtil.success(empService.remove(id));
	}
	
	@DeleteMapping("/{id}")
	public Result removeEmp(@PathVariable Integer id){
		
		return ResultUtil.success(empService.remove(id));
	}

}
