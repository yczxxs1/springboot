package com.google.business.service;

import java.util.List;

import com.google.business.model.Emp;

public interface EmpService {
	public List<Emp> getEmpList();
	
	public Emp getEmp(Emp emp);

	public List<Emp> getEmpList(Emp emp);
	
	public Emp login(Emp emp);
	
	public int save(Emp emp);
	
	public int update(Emp emp);
	
	public int remove(Integer id);
}
