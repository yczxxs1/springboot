package com.netflix.business.event;

import org.springframework.context.ApplicationEvent;

public class PostListVisitEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostListVisitEvent(String loginUserId) {
		super(loginUserId);
		// TODO Auto-generated constructor stub
	}

}
