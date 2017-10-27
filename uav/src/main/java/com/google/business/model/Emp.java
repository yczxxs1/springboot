package com.google.business.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Emp {
	@NotNull(groups=LOGIN.class)
	private Integer empno;

	@NotNull(groups=LOGIN.class)
	private String ename;

	private String job;

	private Short mgr;

	private Date hiredate;

	private BigDecimal sal;

	private BigDecimal comm;

	private Short deptno;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename == null ? null : ename.trim();
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job == null ? null : job.trim();
	}

	public Short getMgr() {
		return mgr;
	}

	public void setMgr(Short mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public BigDecimal getComm() {
		return comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public Short getDeptno() {
		return deptno;
	}

	public void setDeptno(Short deptno) {
		this.deptno = deptno;
	}
	
	
	public interface LOGIN{};

    
}