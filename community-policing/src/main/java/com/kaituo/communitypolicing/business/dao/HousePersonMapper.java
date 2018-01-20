package com.kaituo.communitypolicing.business.dao;

import com.kaituo.communitypolicing.business.model.HousePerson;

public interface HousePersonMapper {
    int insert(HousePerson record);

    int insertSelective(HousePerson record);
}