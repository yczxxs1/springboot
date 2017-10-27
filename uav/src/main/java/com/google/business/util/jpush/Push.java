package com.google.business.util.jpush;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NativeHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.InterfaceAdapter;
import cn.jpush.api.push.model.notification.IosAlert;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.push.model.notification.PlatformNotification;

public class Push {
	 protected static final Logger LOG = LoggerFactory.getLogger(Push.class);

	    // demo App defined in resources/jpush-api.conf 
	    //private static final String appKey ="f945ed681176890104297688";
		//private static final String masterSecret = "bbacd1bf54cdc16fcbe94d93";

	   //刘丰的
	    protected static final String APP_KEY ="424e11690da8d8eaaf35392d";
	    protected static final String MASTER_SECRET = "9915173f11543b8bc4bb5b5c";
	    
		
	    
	    /*不是无锡*/
	 /*   protected static final String APP_KEY ="b7ce64c54ea37306d5a2186d";
	    protected static final String MASTER_SECRET = "0d6c64af0ec149745a049058";*/
	    
		public static final String TITLE = "Test from API example";
	    public static final String ALERT = "Test from API Example - hello";
	    public static final String MSG_CONTENT = "Test from API Example - msgContent";
	    public static final String REGISTRATION_ID = "1507bfd3f7f5ed76ea7";
	    public static final String TAG = "1234567";
	    

		public static void main(String[] args) {
//	        testSendPushWithCustomConfig();
//	        testSendIosAlert();
//			testSendPushByAlias("111", "559CF2934FD6ADC9E050007F01001B74", "55ACE9F6219C0C60E050007F01002D77");
//			testSendPush();
//			testSendWithSMS();
//	        testSendPushes();
	 //       testSendPush_fromJSON();
//	        testSendPushWithCallback();
//	        testSendPushesWithMultiCallback();
		}

	
        //important 广播发送消息
		public static void testSendPush(String alert) {
		    // HttpProxy proxy = new HttpProxy("localhost", 3128);
		    // Can use this https proxy: https://github.com/Exa-Networks/exaproxy
			ClientConfig clientConfig = ClientConfig.getInstance();
	        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
	        String authCode = ServiceHelper.getBasicAuthorization(APP_KEY, MASTER_SECRET);
	        // Here you can use NativeHttpClient or NettyHttpClient.
	        NativeHttpClient httpClient = new NativeHttpClient(authCode, null, clientConfig);
	        // Call setHttpClient to set httpClient,
	        // If you don't invoke this method, default httpClient will use NativeHttpClient.
	        jpushClient.getPushClient().setHttpClient(httpClient);


	        // For push, all you need do is to build PushPayload object.
	       // PushPayload payload = buildPushObject_all_alias_alert();
	        PushPayload payload =  buildPushObject_all_all_alert(alert);  
	        try {
	        	LOG.debug(JSON.toJSONString(payload));
	            PushResult result = jpushClient.sendPush(payload);
	            LOG.info("Got result - " + result);
	            // 如果使用 NettyHttpClient，需要手动调用 close 方法退出进程
	            // If uses NettyHttpClient, call close when finished sending request, otherwise process will not exit.
	            // jpushClient.close();
	        } catch (APIConnectionException e) {
	            LOG.error("Connection error. Should retry later. ", e);
	            LOG.error("Sendno: " + payload.getSendno());

	        } catch (APIRequestException e) {
	            LOG.info("Error response from JPush server. Should review and fix it. ", e);
	            LOG.info("HTTP Status: " + e.getStatus());
	            LOG.info("Error Code: " + e.getErrorCode());
	            LOG.info("Error Message: " + e.getErrorMessage());
	            LOG.info("Msg ID: " + e.getMsgId());
	            LOG.info("Sendno: " + payload.getSendno());
	        }
	    }
	   
		
		//important
		public static void testSendPushByAlias(String alert,String alias,Extra extra) {
		    // HttpProxy proxy = new HttpProxy("localhost", 3128);
		    // Can use this https proxy: https://github.com/Exa-Networks/exaproxy
			ClientConfig clientConfig = ClientConfig.getInstance();
	        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
	        String authCode = ServiceHelper.getBasicAuthorization(APP_KEY, MASTER_SECRET);
	        // Here you can use NativeHttpClient or NettyHttpClient.
	        NativeHttpClient httpClient = new NativeHttpClient(authCode, null, clientConfig);
	        // Call setHttpClient to set httpClient,
	        // If you don't invoke this method, default httpClient will use NativeHttpClient.
	        jpushClient.getPushClient().setHttpClient(httpClient);


	        // For push, all you need do is to build PushPayload object.
	        PushPayload payload = buildPushObject_all_alias_alert(alert,alias,extra);
	        try {
	            PushResult result = jpushClient.sendPush(payload);
	            LOG.info("Got result - " + result);
	            // 如果使用 NettyHttpClient，需要手动调用 close 方法退出进程
	            // If uses NettyHttpClient, call close when finished sending request, otherwise process will not exit.
	            // jpushClient.close();
	        } catch (APIConnectionException e) {
	            LOG.error("Connection error. Should retry later. ", e);
	            LOG.error("Sendno: " + payload.getSendno());

	        } catch (APIRequestException e) {
	        	
	            LOG.error("Error response from JPush server. Should review and fix it: {}", e);
	            LOG.error("HTTP Status: {}" , e.getStatus());
	            LOG.error("Error Code: {}" , e.getErrorCode());
	            LOG.error("Error Message: {}" , e.getErrorMessage());
	            LOG.error("Msg ID: {}" , e.getMsgId());
	            LOG.error("Sendno: {}" , payload.getSendno());
	        }
	    }

		//use String to build PushPayload instance
	    public static void testSendPush_fromJSON() {
	        ClientConfig clientConfig = ClientConfig.getInstance();
	        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
	        Gson gson = new GsonBuilder()
	                .registerTypeAdapter(PlatformNotification.class, new InterfaceAdapter<PlatformNotification>())
	                .create();
	        // Since the type of DeviceType is enum, thus the value should be uppercase, same with the AudienceType.
	        String payloadString = "{\"platform\":{\"all\":false,\"deviceTypes\":[\"IOS\"]},\"audience\":{\"all\":false,\"targets\":[{\"audienceType\":\"TAG_AND\",\"values\":[\"tag1\",\"tag_all\"]}]},\"notification\":{\"notifications\":[{\"soundDisabled\":false,\"badgeDisabled\":false,\"sound\":\"happy\",\"badge\":\"5\",\"contentAvailable\":false,\"alert\":\"Test from API Example - alert\",\"extras\":{\"from\":\"JPush\"},\"type\":\"cn.jpush.api.push.model.notification.IosNotification\"}]},\"message\":{\"msgContent\":\"Test from API Example - msgContent\"},\"options\":{\"sendno\":1429488213,\"overrideMsgId\":0,\"timeToLive\":-1,\"apnsProduction\":true,\"bigPushDuration\":0}}";
	        PushPayload payload = gson.fromJson(payloadString, PushPayload.class);
	        try {
	            PushResult result = jpushClient.sendPush(payload);
	            LOG.info("Got result - " + result);

	        } catch (APIConnectionException e) {
	            LOG.error("Connection error. Should retry later. ", e);
	            LOG.error("Sendno: " + payload.getSendno());

	        } catch (APIRequestException e) {
	            LOG.error("Error response from JPush server. Should review and fix it. ", e);
	            LOG.info("HTTP Status: " + e.getStatus());
	            LOG.info("Error Code: " + e.getErrorCode());
	            LOG.info("Error Message: " + e.getErrorMessage());
	            LOG.info("Msg ID: " + e.getMsgId());
	            LOG.error("Sendno: " + payload.getSendno());
	        }
	    }

	  
		
		public static PushPayload buildPushObject_all_all_alert() {
		    return PushPayload.alertAll(ALERT);
		}
		
		public static PushPayload buildPushObject_all_all_alert(String alert) {
		    return PushPayload.newBuilder()
		    		.setPlatform(Platform.all())
		    		.setAudience(Audience.all())
		    		.setNotification(Notification.alert(alert))
		    		 .setOptions(Options.newBuilder()
	                            .setApnsProduction(true)
	                           .build()) //ios生产环境
		    		.build();
		}
		
	    public static PushPayload buildPushObject_all_alias_alert() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.alias("admin"))
	                .setNotification(Notification.alert(ALERT))
	                .build();
	    }
	    
	    
	    public static PushPayload buildPushObject_all_alias_alert(String alert,String alias,Extra extra) {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.alias(alias))
	                .setNotification(Notification.newBuilder().setAlert(alert)
	                        .addPlatformNotification(IosNotification.newBuilder()
	                                .autoBadge()
	                                .setSound("happy")
	                                .addExtra("messageId", extra.getMessageId())
	                                .addExtra("urlFlag", extra.getUrlFlag())
	                                .build())
	                        .addPlatformNotification(AndroidNotification.newBuilder()
	                                .addExtra("messageId", extra.getMessageId())
	                                .addExtra("urlFlag", extra.getUrlFlag())
	                                .build())
	                        .build())
	                 .setOptions(Options.newBuilder()
                            .setApnsProduction(true)
                           .build()) //重要此为ios生产环境
	                .build();
	    }
	    
	    
	    public static PushPayload buildPushObject_android_tag_alertWithTitle() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android())
	                .setAudience(Audience.tag("tag1"))
	                .setNotification(Notification.android(ALERT, TITLE, null))
	                .build();
	    }
	    
	    public static PushPayload buildPushObject_android_and_ios() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android_ios())
	                .setAudience(Audience.tag("tag1"))
	                .setNotification(Notification.newBuilder()
	                		.setAlert("alert content")
	                		.addPlatformNotification(AndroidNotification.newBuilder()
	                				.setTitle("Android Title").build())
	                		.addPlatformNotification(IosNotification.newBuilder()
	                				.incrBadge(1)
	                				.addExtra("extra_key", "extra_value").build())
	                		.build())
	                .build();
	    }

	    public static void buildPushObject_with_extra() {

	        JsonObject jsonExtra = new JsonObject();
	        jsonExtra.addProperty("extra1", 1);
	        jsonExtra.addProperty("extra2", false);

	        Map<String, String> extras = new HashMap<String, String>();
	        extras.put("extra_1", "val1");
	        extras.put("extra_2", "val2");

	        PushPayload payload = PushPayload.newBuilder()
	                .setPlatform(Platform.android_ios())
	                .setAudience(Audience.tag("tag1"))
	                .setNotification(Notification.newBuilder()
	                        .setAlert("alert content")
	                        .addPlatformNotification(AndroidNotification.newBuilder()
	                                .setTitle("Android Title")
	                                .addExtras(extras)
	                                .addExtra("booleanExtra", false)
	                                .addExtra("numberExtra", 1)
	                                .addExtra("jsonExtra", jsonExtra)
	                                .build())
	                        .addPlatformNotification(IosNotification.newBuilder()
	                                .incrBadge(1)
	                                .addExtra("extra_key", "extra_value").build())
	                        .build())
	                .build();

	        System.out.println(payload.toJSON());
	    }
	    
	    public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.ios())
	                .setAudience(Audience.tag_and("tag1", "tag_all"))
	                .setNotification(Notification.newBuilder()
	                        .addPlatformNotification(IosNotification.newBuilder()
	                                .setAlert(ALERT)
	                                .setBadge(5)
	                                .setSound("happy")
	                                .addExtra("from", "JPush")
	                                .build())
	                        .build())
	                 .setMessage(Message.content(MSG_CONTENT))
	                 .setOptions(Options.newBuilder()
	                         .setApnsProduction(true)
	                         .build())
	                 .build();
	    }

	    public static PushPayload buildPushObject_android_newly_support() {
	        JsonObject inbox = new JsonObject();
	        inbox.add("line1", new JsonPrimitive("line1 string"));
	        inbox.add("line2", new JsonPrimitive("line2 string"));
	        inbox.add("contentTitle", new JsonPrimitive("title string"));
	        inbox.add("summaryText", new JsonPrimitive("+3 more"));
	        Notification notification = Notification.newBuilder()
	                .addPlatformNotification(AndroidNotification.newBuilder()
	                        .setAlert(ALERT)
	                        .setBigPicPath("path to big picture")
	                        .setBigText("long text")
	                        .setBuilderId(1)
	                        .setCategory("CATEGORY_SOCIAL")
	                        .setInbox(inbox)
	                        .setStyle(1)
	                        .setTitle("Alert test")
	                        .setPriority(1)
	                        .build())
	                .build();
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.registrationId("18071adc030dcba91c0"))
	                .setNotification(notification)
	                .setOptions(Options.sendno())
	                .build();
	    }
	    
	    public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android_ios())
	                .setAudience(Audience.newBuilder()
	                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
	                        .addAudienceTarget(AudienceTarget.alias("alias1", "alias2"))
	                        .build())
	                .setMessage(Message.newBuilder()
	                        .setMsgContent(MSG_CONTENT)
	                        .addExtra("from", "JPush")
	                        .build())
	                .build();
	    }

	    

	    public static void testSendIosAlert() {
	        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);

	        IosAlert alert = IosAlert.newBuilder()
	                .setTitleAndBody("test alert", "subtitle", "test ios alert json")
	                .setActionLocKey("PLAY")
	                .build();
	        try {
	            PushResult result = jpushClient.sendIosNotificationWithAlias(alert, new HashMap<String, String>(), "alias1");
	            LOG.info("Got result - " + result);
	        } catch (APIConnectionException e) {
	            LOG.error("Connection error. Should retry later. ", e);
	        } catch (APIRequestException e) {
	            LOG.error("Error response from JPush server. Should review and fix it. ", e);
	            LOG.info("HTTP Status: " + e.getStatus());
	            LOG.info("Error Code: " + e.getErrorCode());
	            LOG.info("Error Message: " + e.getErrorMessage());
	        }
	    }

	  

}
