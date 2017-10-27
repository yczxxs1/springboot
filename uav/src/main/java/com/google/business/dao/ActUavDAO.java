package com.google.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.google.business.model.ActUav;

@Mapper
public interface ActUavDAO {
	int insert(ActUav record);

	int insertSelective(ActUav record);

    ActUav selectOne(ActUav record);
    
    int updateReview(ActUav actUav);
    
    int deleteByPrimaryKey(String id);
    
	List<ActUav> selectActUavList(ActUav actUav);

	List<ActUav> selectActUavByActId(String activityId);
	
	List<ActUav> selectRP(ActUav actUav);
	
	int selectActUavReviewCount(String actId);
	
	int selectActUavReviewCount0(String actId);

}