package com.netflix.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.business.service.LikeUpService;
import com.netflix.common.responseResult.Result;
import com.netflix.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping("/like")
@RestController
@Api(tags = "点赞")
public class LikeUpController {
	
	@Autowired
	private LikeUpService likeUpService;

	@PostMapping
	@ApiOperation(value = "点赞或取消点赞")
	public Result<String> like(@RequestParam @ApiParam(value = "帖子id或者评论id", required = true) String objectId,
			@RequestParam @ApiParam(value = "登录用户id", required = true) String loginUserId) {
		
		return ResultUtil.success(likeUpService.likeOrCancelLike(objectId, loginUserId)?"点赞成功！":"取消点赞成功！");

	}

}
