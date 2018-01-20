package com.netflix.business.domain;

import java.util.Date;

public class PostVisit {
    private String postVisitId;

    private Date postVisitDate;

    private String postVisitUserId;

	private String postVisitPostId;
    
	
	public PostVisit() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public PostVisit(String postVisitUserId, String postVisitPostId) {
		super();
		this.postVisitUserId = postVisitUserId;
		this.postVisitPostId = postVisitPostId;
		this.postVisitDate=new Date();
	}
    

    public String getPostVisitId() {
        return postVisitId;
    }

    public void setPostVisitId(String postVisitId) {
        this.postVisitId = postVisitId == null ? null : postVisitId.trim();
    }

    public Date getPostVisitDate() {
        return postVisitDate;
    }

    public void setPostVisitDate(Date postVisitDate) {
        this.postVisitDate = postVisitDate;
    }

    public String getPostVisitUserId() {
        return postVisitUserId;
    }

    public void setPostVisitUserId(String postVisitUserId) {
        this.postVisitUserId = postVisitUserId == null ? null : postVisitUserId.trim();
    }

    public String getPostVisitPostId() {
        return postVisitPostId;
    }

    public void setPostVisitPostId(String postVisitPostId) {
        this.postVisitPostId = postVisitPostId == null ? null : postVisitPostId.trim();
    }
}