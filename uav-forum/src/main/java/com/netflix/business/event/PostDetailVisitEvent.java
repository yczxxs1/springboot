package com.netflix.business.event;

import org.springframework.context.ApplicationEvent;

import com.netflix.business.domain.PostVisit;

public class PostDetailVisitEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostDetailVisitEvent(PostVisit postVisit) {
		super(postVisit);
		// TODO Auto-generated constructor stub
	}

}
