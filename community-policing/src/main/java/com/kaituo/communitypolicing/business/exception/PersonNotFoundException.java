package com.kaituo.communitypolicing.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Such Person")
public class PersonNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -820787898044936030L;

	
	public PersonNotFoundException(String personId) {
		super("No Such Person: "+personId);
		// TODO Auto-generated constructor stub
	}
	
	

}
