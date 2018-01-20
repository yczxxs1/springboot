package com.netflix.business.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.netflix.business.condition.QueryCondition;
import com.netflix.business.dao.PostImgMapper;
import com.netflix.business.dao.PostMapper;
import com.netflix.business.dao.VisitTimeMapper;
import com.netflix.business.domain.Post;
import com.netflix.business.domain.PostImg;
import com.netflix.business.domain.PostVisit;
import com.netflix.business.domain.VisitTime;
import com.netflix.business.dto.PostDTO;
import com.netflix.business.event.MyPostListVisitEvent;
import com.netflix.business.event.PostDetailVisitEvent;
import com.netflix.business.event.PostListVisitEvent;
import com.netflix.business.exception.PostNotFoundException;
import com.netflix.business.service.CommentService;
import com.netflix.business.service.LikeUpService;
import com.netflix.business.service.PostService;
import com.netflix.business.util.fastDFS.FastDFSFileUtils;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostMapper postMapper;
	@Autowired
	private PostImgMapper postImgMapper;
	@Autowired
	private VisitTimeMapper visitTimeMapper;
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	@Autowired
	private LikeUpService likeUpService;
	@Autowired
	private CommentService commentService;


	@Override
	public void post(Post post, List<File> files) throws Exception {
		// TODO Auto-generated method stub
		postMapper.insert(post);
		for (File file : files) {
			BufferedImage bufferedImage = ImageIO.read(file);
			String postImgUrl = FastDFSFileUtils.uploadFileToDfs(file);// 上传文件服务器
			postImgMapper.insertSelective(
					new PostImg(postImgUrl, bufferedImage.getHeight(), bufferedImage.getWidth(), post.getPostId()));// 图片地址入库
		}

	}

	@Override
	public List<PostDTO> listPost(QueryCondition qc) throws Exception {
		// TODO Auto-generated method stub
		List<PostDTO> list = postMapper.selectList(qc);
		return list;
	}

	@Override
	public PostDTO getPost(String postId) throws Exception {
		// TODO Auto-generated method stub
		PostDTO postDTO=postMapper.selectByPrimaryKey(postId);
		if(postDTO==null) throw new PostNotFoundException(postId);
		postDTO.setPostImgs(postImgMapper.selectListByPostId(postId));
		return postDTO; 
	}

	@Override
	public void publishPostListVisitEvent(boolean isMyPostList, String loginUserId) throws Exception {
		// TODO Auto-generated method stub
		if (isMyPostList) {
			applicationEventPublisher.publishEvent(new MyPostListVisitEvent(loginUserId));
		} else {
			applicationEventPublisher.publishEvent(new PostListVisitEvent(loginUserId));
		}

	}

	@Override
	public void publishPostDetailVisitEvent(String loginUserId, String postId) throws Exception {
		// TODO Auto-generated method stub
		applicationEventPublisher.publishEvent(new PostDetailVisitEvent(new PostVisit(loginUserId,postId)));
		
	}

	@Override
	public int countLatestPost(String loginUserId) throws Exception {
		// TODO Auto-generated method stub
		QueryCondition qc=new QueryCondition();
		VisitTime visitTime=visitTimeMapper.selectByVisitTimeUserId(loginUserId);
		if(visitTime==null) {
			return 0;
		}
		qc.setPostListVisitTime(visitTime.getVisitTimePost());
		return postMapper.selectCountByCondition(qc);
	}

	@Override
	public List<PostDTO> listPost(QueryCondition qc, String loginUserId) throws Exception {
		// TODO Auto-generated method stub
		List<PostDTO> list=listPost(qc);
		for(PostDTO postDTO:list) {
			postDTO.setPostLikeStatus(likeUpService.getLikeUpStatus(postDTO.getPostId(), loginUserId));
			//最新评论数
			if(qc.getPostUserId()!=null) {
				postDTO.setLatestCommentCount(commentService.countLatestComment(loginUserId, postDTO.getPostId()));
			}
		}	
		return list;
	}

}
