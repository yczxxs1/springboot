package com.netflix.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Such Post")
public class PostNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3721580437518982338L;

	/**
	 * 
	 * @param postId
	 */
	public PostNotFoundException(String postId) {
		super("no such post:"+postId);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
