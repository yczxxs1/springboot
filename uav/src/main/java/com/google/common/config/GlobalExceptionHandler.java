package com.google.common.config;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.common.exception.ServiceException;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultCode;

//全局统一异常处理
@RestControllerAdvice
public class GlobalExceptionHandler {
	//private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	//@ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")
	@ExceptionHandler(value = ServiceException.class)
	public Result serviceErrorHandler(HttpServletRequest req, ServiceException e) throws Exception {
		//logger.debug("Request: " + req.getRequestURL() + " raised " + e);
		return new Result(e.getMessage());
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public Result IllegalArgumentExceptionErrorHandler(HttpServletRequest req, ServiceException e) throws Exception {
		//logger.debug("Request: " + req.getRequestURL() + " raised " + e);
		return new Result(e.getMessage());
	}

	@ExceptionHandler(value = BindException.class)
	public Result validationErrorHandler(HttpServletRequest req, Exception e) throws Exception {

		return new Result(ResultCode.VALIDATION);
	}

	@ExceptionHandler(value = SQLException.class)
	public Result sqlErrorHandler(HttpServletRequest req, SQLException e) throws Exception {

		return new Result(ResultCode.DATABASE);
	}
	
	
	/*@ExceptionHandler(value = Exception.class)
	public Result defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.warn("exception :{}",e);
		return new Result(ResultCode.ERROR);
	}*/
	
	
	

}
