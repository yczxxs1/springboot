package com.netflix.business.event;

import org.springframework.context.ApplicationEvent;

public class MyPostListVisitEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyPostListVisitEvent(String loginUserId) {
		super(loginUserId);
		// TODO Auto-generated constructor stub
	}

}
