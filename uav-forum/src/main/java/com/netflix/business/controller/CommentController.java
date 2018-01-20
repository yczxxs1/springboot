package com.netflix.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.business.conversion.ClassMap;
import com.netflix.business.domain.PostComment;
import com.netflix.business.dto.PostCommentDTO;
import com.netflix.business.form.CommentForm;
import com.netflix.business.service.CommentService;
import com.netflix.business.service.PostService;
import com.netflix.business.vo.PageVO;
import com.netflix.business.vo.PostCommentVO;
import com.netflix.common.responseResult.Result;
import com.netflix.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ma.glasnost.orika.MapperFacade;

@RequestMapping("/comment")
@RestController
@Api(tags = "评论")
public class CommentController {
	
	@Autowired
	private MapperFacade mapperFacade;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ClassMap classMapRule;
	
	
	@PostMapping
	@ApiOperation(value="发布评论")
	public Result<String> comment(@Validated CommentForm commentForm) throws Exception{
		commentService.comment(mapperFacade.map(commentForm, PostComment.class));
		return ResultUtil.success();
		
	}
	
	@GetMapping("/list")
	@ApiOperation(value="评论列表")
	public Result<PageVO<PostCommentVO>> listComments(@RequestParam String loginUserId ,@RequestParam String postId,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) throws Exception{
		postService.getPost(postId);//校验postId
		PageHelper.startPage(page, size);
		PageInfo<PostCommentVO> pageInfo=classMapRule.pageCommentDTO2PageCommentListVO(new PageInfo<PostCommentDTO>(commentService.listComment(postId,loginUserId)));
		return ResultUtil.success(new PageVO<PostCommentVO>(pageInfo));
		
	}
	
	
	
	@GetMapping("/newOrNot")
	@ApiOperation(value="我的帖子是否有新评论")
	public Result<Boolean> hasNewComments(@RequestParam @ApiParam("登录用户id")String loginUserId) throws Exception {
		
		return ResultUtil.success(commentService.countLatestComment(loginUserId,null)!=0);
	}

}
