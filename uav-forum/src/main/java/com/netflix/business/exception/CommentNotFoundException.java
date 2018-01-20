package com.netflix.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Such Comment")
public class CommentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5588383671076533741L;

	/**
	 * 
	 * @param commentId
	 */
	public CommentNotFoundException(String commentId) {
		super("no such comment:"+commentId);
		// TODO Auto-generated constructor stub
	}
	
	

}
