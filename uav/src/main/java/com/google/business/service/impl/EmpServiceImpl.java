package com.google.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.business.dao.EmpDAO;
import com.google.business.model.Emp;
import com.google.business.service.EmpService;
import com.google.common.exception.ServiceException;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDAO empDAO;
	
	@Override
	public List<Emp> getEmpList(Emp emp) {
		return empDAO.selectList(emp);
	}

	@Override
	public Emp getEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDAO.selectOne(emp);
	}

	@Override
	public List<Emp> getEmpList() {
		// TODO Auto-generated method stub
		return empDAO.selectList(new Emp());
	}

	@Override
	public Emp login(Emp emp) {
		// TODO Auto-generated method stub
		Emp emp1=empDAO.selectOne(emp);
		if(emp1==null){
			throw new ServiceException("用户不存在！");
		}
		return emp1;
	}

	@Override
	public int save(Emp emp) {
		// TODO Auto-generated method stub
		return empDAO.insertSelective(emp);
	}

	@Override
	public int update(Emp emp) {
		// TODO Auto-generated method stub
		return empDAO.updateByPrimaryKeySelective(emp);
	}

	@Override
	public int remove(Integer id) {
		// TODO Auto-generated method stub
		return empDAO.deleteByPrimaryKey(id);
	}
	
	

}
