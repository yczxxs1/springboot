package com.google.business.util.sms;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

//全文模板发送
public class SendMsg {
	private final static Logger logger = LoggerFactory.getLogger(SendMsg.class);

	protected static final String AC = "send";
	protected static final String UID = "jsktwrj";
	protected static final String PWD = "e5f773311be36ac928b79cdd2677afbe";
	protected static final String TEMPLATE = "401760";

	// 发送手机接口
	public static ResponseEntity sendMsg(String mobile) throws Exception {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("https://api.sms.cn/sms/");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
		String randomNum = RandomUtils.nextInt(10000, 99999) + "";

		NameValuePair[] data = { new NameValuePair("ac", AC), new NameValuePair("uid", UID),
				new NameValuePair("pwd", PWD), new NameValuePair("template", TEMPLATE),
				new NameValuePair("mobile", mobile),
				new NameValuePair("content", "{\"code\":" + "\"" + randomNum + "\"" + "}") };
		post.setRequestBody(data);
		client.executeMethod(post);
		// Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		logger.info("sms http statusCode: {}", statusCode);
		String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
		logger.info("sms request result: {}" + result);	
		post.releaseConnection();
		ResponseEntity re =  JSON.parseObject(result,ResponseEntity.class);
		re.setRandomNum(randomNum);
		return re;
	}
	// 测试
	/*
	 * public static void main(String[] args)throws Exception { HttpClient
	 * client = new HttpClient(); PostMethod post = new
	 * PostMethod("http://api.sms.cn/sms/");
	 * post.addRequestHeader("Content-Type",
	 * "application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
	 * NameValuePair[] data ={ new NameValuePair("ac", "send"), new
	 * NameValuePair("uid", "jsktwrj"), new NameValuePair("pwd",
	 * "e5f773311be36ac928b79cdd2677afbe"), new
	 * NameValuePair("template","401760"), new
	 * NameValuePair("mobile","13024338912"), new
	 * NameValuePair("content","{\"code\":"+"\""+"来自小柏柏的一条短信"+"\""+"}")};
	 * post.setRequestBody(data);
	 * System.out.println("{\"code\":"+"\""+StringRandom.getNumRandom(5)+"\""+
	 * "}");
	 * System.out.println("{\"code\":"+"{\"code\":"+"\""+"来自小柏柏的一条短信"+"\""+"}"+
	 * "}"); client.executeMethod(post); Header[] headers =
	 * post.getResponseHeaders(); int statusCode = post.getStatusCode();
	 * System.out.println("statusCode:"+statusCode); for(Header h : headers) {
	 * System.out.println(h.toString()); } String result = new
	 * String(post.getResponseBodyAsString().getBytes("utf-8"));
	 * System.out.println(result); //打印返回消息状态 post.releaseConnection();
	 * 
	 * }
	 */

}
