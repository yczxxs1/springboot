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
import com.netflix.business.domain.Reply;
import com.netflix.business.dto.ReplyDTO;
import com.netflix.business.form.ReplyForm;
import com.netflix.business.service.CommentService;
import com.netflix.business.service.LikeUpService;
import com.netflix.business.service.ReplyService;
import com.netflix.business.vo.PageVO;
import com.netflix.business.vo.PostCommentVO;
import com.netflix.business.vo.ReplyVO;
import com.netflix.common.responseResult.Result;
import com.netflix.common.responseResult.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.glasnost.orika.MapperFacade;

@RequestMapping("/reply")
@RestController
@Api(tags = "回复")
public class ReplyController {
	
	@Autowired
	private MapperFacade mapperFacade;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LikeUpService likeUpService;
	
	@Autowired
	private ClassMap classMap;
	
	private static final Integer replyPage = 1;

	private static final Integer replySize = 2;
	
	@PostMapping
	@ApiOperation(value="回复",notes="回复成功后返回回复所在评论+0-2条回复")
	public Result<PostCommentVO> reply(@Validated ReplyForm replyForm) throws Exception{
		replyService.reply(mapperFacade.map(replyForm, Reply.class));
		
		String commentId=replyForm.getReplyCommentId();
		PostCommentVO postCommentVO=mapperFacade.map(commentService.getComment(commentId), PostCommentVO.class);
		postCommentVO.setCommentLikeStatus(likeUpService.getLikeUpStatus(commentId, replyForm.getReplyUserId()));
		//0-2条回复
		PageHelper.startPage(replyPage, replySize);
		postCommentVO.setReplys(mapperFacade.mapAsList(replyService.listReply(commentId), ReplyVO.class));
		
		return ResultUtil.success(postCommentVO);
		
	}
	
	@GetMapping("/list")
	@ApiOperation(value="回复列表")
	public Result<PageVO<ReplyVO>> listReplys(@RequestParam String replyCommentId,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) throws Exception{
		PageHelper.startPage(page, size);
		PageInfo<ReplyVO> pageInfo=classMap.pageReplyDTO2PageReplyVO(new PageInfo<ReplyDTO>(replyService.listReply(replyCommentId)));
		return ResultUtil.success(new PageVO<ReplyVO>(pageInfo));
		
	}

}
