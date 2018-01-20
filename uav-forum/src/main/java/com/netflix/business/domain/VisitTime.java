package com.netflix.business.domain;

import java.util.Date;
//实体
public class VisitTime {
    private String visitTimeId;

    private Date visitTimePost;

    private Date visitTimeMyPost;

    private String visitTimeUserId;
    
    
    

    public VisitTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisitTime( String visitTimeUserId) {
		super();
		
		this.visitTimePost = new Date(0L);
		this.visitTimeMyPost = new Date(0L);
		this.visitTimeUserId = visitTimeUserId;
	}

	public String getVisitTimeId() {
        return visitTimeId;
    }

    public void setVisitTimeId(String visitTimeId) {
        this.visitTimeId = visitTimeId == null ? null : visitTimeId.trim();
    }

    public Date getVisitTimePost() {
        return visitTimePost;
    }

    public void setVisitTimePost(Date visitTimePost) {
        this.visitTimePost = visitTimePost;
    }

    public Date getVisitTimeMyPost() {
        return visitTimeMyPost;
    }

    public void setVisitTimeMyPost(Date visitTimeMyPost) {
        this.visitTimeMyPost = visitTimeMyPost;
    }

    public String getVisitTimeUserId() {
        return visitTimeUserId;
    }

    public void setVisitTimeUserId(String visitTimeUserId) {
        this.visitTimeUserId = visitTimeUserId == null ? null : visitTimeUserId.trim();
    }
}