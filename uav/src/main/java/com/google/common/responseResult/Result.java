package com.google.common.responseResult;

public class Result {

	private int status;
	private String message;
	private Object data;

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	//业务异常返回结果
	public Result(String message) {
		super();
		this.status = ResultCode.BUSINESS.getCode();
		this.message = message;
	}

	public Result() {
		super();
	}

	//非业务异常
	public Result(ResultCode resultCode) {
		super();
		this.status=resultCode.getCode();
		this.message=resultCode.getMessage();	
	}
	//成功返回
	public Result(Object data) {
		super();
		this.status=ResultCode.SUCCESS.getCode();
		this.message=ResultCode.SUCCESS.getMessage();
		this.data=data;
	}
	
}
