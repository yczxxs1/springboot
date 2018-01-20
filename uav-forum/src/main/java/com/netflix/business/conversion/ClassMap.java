package com.netflix.business.conversion;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.netflix.business.dto.PostCommentDTO;
import com.netflix.business.dto.PostDTO;
import com.netflix.business.dto.ReplyDTO;
import com.netflix.business.vo.MyPostListVO;
import com.netflix.business.vo.PostCommentVO;
import com.netflix.business.vo.PostListVO;
import com.netflix.business.vo.ReplyVO;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeBuilder;

@Component
public final class ClassMap {

	@Autowired
	private MapperFactory mapperFactory;

	@Autowired
	private MapperFacade mapperFacade;

	@PostConstruct
	private final void postDTO2PostListVO() {

		mapperFactory.classMap(PostDTO.class, PostListVO.class).byDefault()
				.customize(new CustomMapper<PostDTO, PostListVO>() {
					public void mapAtoB(PostDTO postDTO, PostListVO postListVO, MappingContext context) {
						// add your custom mapping code here
						postListVO.setHasPostImg(postDTO.getPostImgCount() == 0 ? false : true);
					}

				}).register();
	}



	@PostConstruct
	private final void postCommentDTO2PostCommentVO() {

		mapperFactory.classMap(PostCommentDTO.class, PostCommentVO.class).byDefault()
				.customize(new CustomMapper<PostCommentDTO, PostCommentVO>() {
					public void mapAtoB(PostCommentDTO postCommentDTO, PostCommentVO postCommentVO,
							MappingContext context) {
						// add your custom mapping code here
						List<ReplyDTO> replys = postCommentDTO.getReplys();
						if (replys != null) {
							postCommentVO.setReplys(mapperFacade.mapAsList(postCommentDTO.getReplys(), ReplyVO.class));
						}
					}

				}).register();
	}

	@PostConstruct
	private final void pageInfoPostDTO2PageInfoMyPostListVO() {
		Type<PageInfo<PostDTO>> fromType = new TypeBuilder<PageInfo<PostDTO>>() {
		}.build();
		Type<PageInfo<MyPostListVO>> toType = new TypeBuilder<PageInfo<MyPostListVO>>() {
		}.build();
		mapperFactory.classMap(fromType, toType).byDefault()
				.customize(new CustomMapper<PageInfo<PostDTO>, PageInfo<MyPostListVO>>() {
					public void mapAtoB(PageInfo<PostDTO> pageInfoPostDTO, PageInfo<MyPostListVO> pageInfoMyPostListVO,
							MappingContext context) {
						// add your custom mapping code here
						List<PostDTO> postDTOs = pageInfoPostDTO.getList();
						List<MyPostListVO> myPostListVOs = pageInfoMyPostListVO.getList();

						for (int i = 0; i < postDTOs.size(); i++) {
							myPostListVOs.get(i).setLatestCommentCount(postDTOs.get(i).getLatestCommentCount());
						}

					}

				}).register();

	}

	public final PageInfo<PostListVO> pagePostDTO2PagePostListVO(PageInfo<PostDTO> pageInfo) {

	/*	Type<PageInfo<PostDTO>> fromType = new TypeBuilder<PageInfo<PostDTO>>() {
		}.build();
		Type<PageInfo<PostListVO>> toType = new TypeBuilder<PageInfo<PostListVO>>() {
		}.build();
		return mapperFacade.map(pageInfo, fromType, toType);*/
		
		
		  PageInfo<PostListVO> pageInfoVO=new PageInfo<PostListVO>();
		  mapperFacade.map(pageInfo, pageInfoVO); 
		  return pageInfoVO;
		 
	}

	public final PageInfo<MyPostListVO> pagePostDTO2PageMyPostListVO(PageInfo<PostDTO> pageInfo) {

		/*
		 * PageInfo<MyPostListVO> pageInfoVO=new PageInfo<MyPostListVO>();
		 * mapperFacade.map(pageInfo, pageInfoVO); return pageInfoVO;
		 */
		Type<PageInfo<PostDTO>> fromType = new TypeBuilder<PageInfo<PostDTO>>() {
		}.build();
		Type<PageInfo<MyPostListVO>> toType = new TypeBuilder<PageInfo<MyPostListVO>>() {
		}.build();
		return mapperFacade.map(pageInfo, fromType, toType);

	}

	public final PageInfo<PostCommentVO> pageCommentDTO2PageCommentListVO(PageInfo<PostCommentDTO> pageInfo) {

		Type<PageInfo<PostCommentDTO>> fromType = new TypeBuilder<PageInfo<PostCommentDTO>>() {
		}.build();
		Type<PageInfo<PostCommentVO>> toType = new TypeBuilder<PageInfo<PostCommentVO>>() {
		}.build();
		return mapperFacade.map(pageInfo, fromType, toType);

	}

	public final PageInfo<ReplyVO> pageReplyDTO2PageReplyVO(PageInfo<ReplyDTO> pageInfo) {

		Type<PageInfo<ReplyDTO>> fromType = new TypeBuilder<PageInfo<ReplyDTO>>() {
		}.build();
		Type<PageInfo<ReplyVO>> toType = new TypeBuilder<PageInfo<ReplyVO>>() {
		}.build();
		return mapperFacade.map(pageInfo, fromType, toType);

	}

}
