package com.google.common.responseResult;

public class ResultUtil {
	
	public static Result success(Object data){
		Result result=new Result();
		result.setData(data);
		result.setMessage(ResultCode.SUCCESS.getMessage());
		result.setStatus(ResultCode.SUCCESS.getCode());
		return result;
		
	}
	
	public static Result success(){
		Result result=new Result();
		result.setData(ResultCode.SUCCESS.getMessage());
		result.setStatus(ResultCode.SUCCESS.getCode());
		return result;
		
	}
	

}
