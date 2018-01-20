package com.netflix.business.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.netflix.business.dao.PostVisitMapper;
import com.netflix.business.dao.VisitTimeMapper;
import com.netflix.business.domain.PostVisit;
import com.netflix.business.domain.VisitTime;
import com.netflix.business.event.MyPostListVisitEvent;
import com.netflix.business.event.PostDetailVisitEvent;
import com.netflix.business.event.PostListVisitEvent;
import com.netflix.business.service.ForumStatisticsService;

@Service
public class ForumStatisticsImpl implements ForumStatisticsService {
	
	@Autowired
	private PostVisitMapper postVisitMapper;
	
	@Autowired
	private VisitTimeMapper visitTimeMapper;

	//监听帖子列表访问事件，记录帖子最后访问时间
	@EventListener
	public void updatePostListVisitTime(PostListVisitEvent postListVisitEvent) {
		// TODO Auto-generated method stub
		String loginUserId=(String) postListVisitEvent.getSource();
		VisitTime visitTime=visitTimeMapper.selectByVisitTimeUserId(loginUserId);
		if(visitTime==null) {
			visitTime=new VisitTime(loginUserId);
			visitTimeMapper.insertSelective(visitTime);
		}else {
			visitTime.setVisitTimePost(new Date());
			visitTimeMapper.updateByPrimaryKeySelective(visitTime);
		}
		
	}
	
	
	//监听我的帖子访问列表事件，记录我帖子最后访问时间
	@EventListener
	public void updateMyPostListVisitTime(MyPostListVisitEvent postListVisitEvent) {
		// TODO Auto-generated method stub
		String loginUserId=(String) postListVisitEvent.getSource();
		VisitTime visitTime=visitTimeMapper.selectByVisitTimeUserId(loginUserId);
		if(visitTime==null) {
			visitTime=new VisitTime(loginUserId);
			visitTimeMapper.insertSelective(visitTime);
		}else {
			visitTime.setVisitTimeMyPost(new Date());
			visitTimeMapper.updateByPrimaryKeySelective(visitTime);
		}
		
	}
	
	//监听帖子详情访问事件，记录访问时间
	@EventListener
	public void savePostDetailVisitTime(PostDetailVisitEvent postDetailVisitEvent) {
		// TODO Auto-generated method stub
		postVisitMapper.insertSelective((PostVisit)postDetailVisitEvent.getSource());
		
	}

}
