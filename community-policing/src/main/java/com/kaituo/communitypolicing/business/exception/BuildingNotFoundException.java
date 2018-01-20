package com.kaituo.communitypolicing.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Such Building")
public class BuildingNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4587783904670551834L;
	/**
	 * 
	 */
	
	public  BuildingNotFoundException(String buildingId) {
		super("No Such Building: "+buildingId);
		// TODO Auto-generated constructor stub
	}
	
	

}
