package com.google.business.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.business.dto.PageDTO;
import com.google.business.model.MessageEntity;
import com.google.business.service.MessageService;
import com.google.business.vo.MessageVO;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/message")
@Api(description="消息相关操作")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@ApiOperation(value="获取消息列表")
	@PostMapping("/getMessageList")//
	public Result getMessageList(@RequestParam String messageType,@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size,String userId){
		MessageEntity me = new MessageEntity();
		me.setUserId(userId);
		me.setMessagetype(messageType);
		PageHelper.startPage(page, size);
		PageInfo<MessageEntity> pageInfo = new PageInfo<MessageEntity>(messageService.getMessages(me));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
	
	@ApiOperation(value="获取一条消息详情")
	@PostMapping("/getMessageDetail")
	public Result getMessageDetail(MessageEntity me){
		return  ResultUtil.success(messageService.getMessageDetail(me));
	}
	
	@ApiOperation(value="删除一条消息")
	@PostMapping("/delMessage")
	public Result delMessage(@RequestParam String id){
		messageService.delMessage(id);
		return  ResultUtil.success();
	}
	
	@ApiOperation(value="地图推送")
	@PostMapping("/push")
	public Result pushMes(@RequestParam String userId,@RequestParam String content){
	    messageService.push(userId, content);
		return ResultUtil.success();
		
	}

	@ApiOperation(value="广播推送")
	@PostMapping("/pushBroadcast")
	public Result pushBroadcast(@RequestParam String title,@RequestParam String content){
	    messageService.pushBroadcast(title, content);
		return ResultUtil.success();
		
	}
	
	@ApiOperation(value="获取广播消息列表web端")
	@PostMapping("/getBroadcastList")//
	public Result getBroadcastMessageList(@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "0") Integer size, 
			Long starttime,Long endtime,MessageVO messageVO){
		if(starttime!=null){
			messageVO.setStartTime(new Date(starttime));
		}
		if(endtime!=null){
			messageVO.setEndTime(new Date(endtime));	
		}	
		PageHelper.startPage(page, size);
		PageInfo<MessageEntity> pageInfo = new PageInfo<MessageEntity>(messageService.getBroadcastList( messageVO));
		return ResultUtil.success(new PageDTO(pageInfo));
	}
	
}
