package com.kaituo.communitypolicing.business.service;

import java.util.List;

import com.kaituo.communitypolicing.business.condition.Condition;
import com.kaituo.communitypolicing.business.domain.Person;
import com.kaituo.communitypolicing.business.exception.PersonNotFoundException;

public interface PersonService {
	
	/**
	 * 室的人员列表
	 * @param houseId
	 * @return List<Person>
	 */
	public List<Person> listByHouseId(String houseId);
	
	/**
	 * 非独栋楼房的人员列表
	 * @param BungalowId
	 * @return List<Person>
	 */
	public List<Person> listByBungalowId(String BungalowId);
	
	/**
	 * 人员详情
	 * @param personId
	 * @return Person
	 * @throws PersonNotFoundException
	 */
	public Person getPerson(String personId) throws PersonNotFoundException;
	
	/**
	 * 按条件查询人员列表
	 * @param condition
	 * @return List<Person>
	 */
	public List<Person> listByConditon(Condition condition);

}
