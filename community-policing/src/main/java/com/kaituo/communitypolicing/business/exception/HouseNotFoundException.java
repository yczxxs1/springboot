package com.kaituo.communitypolicing.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Such House")
public class HouseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -285421923355632576L;

	public HouseNotFoundException(String houseId) {
		super("No Such House :"+houseId);
		// TODO Auto-generated constructor stub
	}
	
	

}
