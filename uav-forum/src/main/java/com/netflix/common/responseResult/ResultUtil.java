package com.netflix.common.responseResult;

public class ResultUtil {
	
	public static <T> Result<T> success(T data){
		Result<T> result=new Result<T>();
		result.setData(data);
		result.setMessage(ResultCode.SUCCESS.getMessage());
		result.setStatus(ResultCode.SUCCESS.getCode());
		return result;
		
	}
	
	
	public static Result<String> success(){
		Result<String> result=new Result<String>();
		result.setData(ResultCode.SUCCESS.getMessage());
		result.setStatus(ResultCode.SUCCESS.getCode());
		return result;
		
	}
	

}
