package com.google.business.dto;

import com.github.pagehelper.PageInfo;

public class PageDTO {
	private Integer page;
	private Integer size;
	private Integer lastPage;
	private Long total;
	private Object list;

	

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	
	public PageDTO(PageInfo<?> pageinfo) {
		super();
		this.page = pageinfo.getPageNum();
		this.size = pageinfo.getPageSize();
		this.lastPage = pageinfo.getNavigateLastPage();
		this.total = pageinfo.getTotal();
		this.list = pageinfo.getList();
	}

	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	
	
}
