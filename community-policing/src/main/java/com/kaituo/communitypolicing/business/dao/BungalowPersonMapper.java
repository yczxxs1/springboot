package com.kaituo.communitypolicing.business.dao;

import com.kaituo.communitypolicing.business.model.BungalowPerson;

public interface BungalowPersonMapper {
    int insert(BungalowPerson record);

    int insertSelective(BungalowPerson record);
}