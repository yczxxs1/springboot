package com.kaituo.communitypolicing.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaituo.communitypolicing.business.condition.Condition;
import com.kaituo.communitypolicing.business.domain.Person;
import com.kaituo.communitypolicing.business.exception.PersonNotFoundException;
import com.kaituo.communitypolicing.business.repository.PersonRepository;
import com.kaituo.communitypolicing.business.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> listByHouseId(String houseId) {
		// TODO Auto-generated method stub
		return personRepository.selectByHouseId(houseId);
	}

	@Override
	public List<Person> listByBungalowId(String bungalowId) {
		// TODO Auto-generated method stub
		return personRepository.selectByBungalowId(bungalowId);
	}

	@Override
	public Person getPerson(String personId) throws PersonNotFoundException {
		// TODO Auto-generated method stub
		Person person=personRepository.selectByPrimaryKey(personId);
		if(person==null) throw new PersonNotFoundException(personId);
		return person;
	}

	@Override
	public List<Person> listByConditon(Condition condition) {
		// TODO Auto-generated method stub
		return personRepository.listByConditon(condition);
	}

}
