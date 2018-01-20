package com.netflix.business.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.business.condition.QueryCondition;
import com.netflix.business.conversion.ClassMap;
import com.netflix.business.domain.Post;
import com.netflix.business.dto.PostDTO;
import com.netflix.business.form.PostForm;
import com.netflix.business.form.PostQueryForm;
import com.netflix.business.service.LikeUpService;
import com.netflix.business.service.PostService;
import com.netflix.business.vo.MyPostListVO;
import com.netflix.business.vo.PageVO;
import com.netflix.business.vo.PostDetailVO;
import com.netflix.business.vo.PostImgVO;
import com.netflix.business.vo.PostListVO;
import com.netflix.common.responseResult.Result;
import com.netflix.common.responseResult.ResultUtil;
import com.netflix.common.util.ControllerFileUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ma.glasnost.orika.MapperFacade;

@RequestMapping("/post")
@RestController
@Api(tags = "帖子")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private MapperFacade mapperFacade;

	@Autowired
	private LikeUpService likeUpService;
	
	@Autowired
	private ClassMap classMapRule;


	



	@PostMapping
	@ApiOperation(value = "发布帖子", notes = "将表单数据转成json报文 key为jsonStr，文件上传字段为file;postTitle:标题,postContent:内容,postUserId:用户id")
	public Result<String> post(@RequestParam("file") MultipartFile[] files, @RequestParam String jsonStr)
			throws Exception {
		List<File> destFiles = ControllerFileUtils.transferToFileList(files);
		PostForm postForm = JSON.parseObject(jsonStr, PostForm.class);
		postForm.validate();// 校验表单数据
		Post post = mapperFacade.map(postForm, Post.class);
		postService.post(post, destFiles);
		return ResultUtil.success();

	}

	@GetMapping("/list")
	@ApiOperation(value = "查看帖子列表")
	public Result<PageVO<PostListVO>> listPosts(@RequestParam String loginUserId, PostQueryForm postQueryForm,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size)
			throws Exception {
		PageHelper.startPage(page, size);
		PageInfo<PostListVO> pageInfoVO = classMapRule.pagePostDTO2PagePostListVO( new PageInfo<PostDTO>(postService.listPost(mapperFacade.map(postQueryForm, QueryCondition.class),loginUserId)));
		postService.publishPostListVisitEvent(false, loginUserId);// 发布访问事件
		return ResultUtil.success(new PageVO<PostListVO>(pageInfoVO));
	}

	@GetMapping("/myList")
	@ApiOperation(value = "查看我的帖子列表")
	public Result<PageVO<MyPostListVO>> listMyPosts(@RequestParam String loginUserId,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size)
			throws Exception {
		PageHelper.startPage(page, size);
		QueryCondition qc = new QueryCondition();
		qc.setPostUserId(loginUserId);
		PageInfo<MyPostListVO> pageInfoVO =classMapRule.pagePostDTO2PageMyPostListVO(new PageInfo<PostDTO>(postService.listPost(qc,loginUserId)));
		postService.publishPostListVisitEvent(true, loginUserId);// 发布访问事件
		return ResultUtil.success(new PageVO<MyPostListVO>(pageInfoVO));
	}

	@GetMapping("/{postId}")
	@ApiOperation(value = "查看帖子详情", notes = "postId帖子id(在url上),loginUserId登录用户id")
	public Result<PostDetailVO> getPost(@PathVariable String postId, @RequestParam String loginUserId)
			throws Exception {
		PostDTO postDTO=postService.getPost(postId);
		PostDetailVO postDetailVO = mapperFacade.map(postService.getPost(postId), PostDetailVO.class);
		postDetailVO.setPostLikeStatus(likeUpService.getLikeUpStatus(postId, loginUserId));//帖子点赞状态
		postDetailVO.setPostImgs(mapperFacade.mapAsList(postDTO.getPostImgs(), PostImgVO.class));//帖子图片
		
		postService.publishPostDetailVisitEvent(loginUserId, postId);//发布访问事件
		return ResultUtil.success(postDetailVO);
	}

	@GetMapping("/newOrNot")
	@ApiOperation(value = "查看是否有新帖")
	public Result<Boolean> hasNewPosts(@RequestParam @ApiParam("登录用户id") String loginUserId) throws Exception {
       
		return ResultUtil.success(postService.countLatestPost(loginUserId)!=0);
	}

}
