package com.kaituo.communitypolicing.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kaituo.communitypolicing.business.condition.Condition;
import com.kaituo.communitypolicing.business.domain.Person;
@Mapper
public interface PersonMapper {
	
	int selectCountByHouse(Condition condition);
	
	List<Person> selectByHouseId(String houseId);
	
	List<Person> selectByBungalowId(String bungalowId);
	
	List<Person> listByConditon(Condition condition);
	
	
	
	
	
	
    int deleteByPrimaryKey(String personId);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String personId);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}