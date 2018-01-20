package com.netflix.common.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.netflix.common.exception.ServiceException;
import com.netflix.common.responseResult.Result;

//全局统一异常处理
@RestControllerAdvice
@SuppressWarnings("rawtypes")
public class GlobalExceptionHandler {



	@ExceptionHandler(value = ServiceException.class)
	public  Result serviceErrorHandler(HttpServletRequest request, HttpServletResponse response,ServiceException e) throws Exception {
		return new Result(e.getMessage());
	}
	


	
	/*@ExceptionHandler(value = IllegalArgumentException.class)
	public void IllegalArgumentExceptionErrorHandler(HttpServletRequest req, HttpServletResponse response, IllegalArgumentException e) throws Exception {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}*/
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Result> IllegalArgumentExceptionErrorHandler(HttpServletRequest req, HttpServletResponse response, IllegalArgumentException e) throws Exception {
		//HttpStatus status = HttpStatus.BAD_REQUEST;
		ResponseEntity<Result> responseEntity=new ResponseEntity<Result>(new Result(e.getMessage()),HttpStatus.BAD_REQUEST);
		return responseEntity;
	}


	

	

}
