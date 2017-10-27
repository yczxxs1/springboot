package com.google.business.service;


import com.google.business.model.Person;

public interface PersonService {
	public void saveOrUpdate(Person person,String areaId);
}
