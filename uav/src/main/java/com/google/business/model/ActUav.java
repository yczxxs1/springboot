package com.google.business.model;

import java.util.List;

public class ActUav {
    private String id;

    private String actId;

    private String snNumber;

    private String userName;
    
    private String userNumber;

    private String userPhone;

    private String card;
    
    private String review;
    
    private String phUrl;
    
	private int auReviewCount;

    public String getId() {
        return id;
    }
    
	private List<InsurancePhoto> insPhotos;

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId == null ? null : actId.trim();
    }

    public String getSnNumber() {
        return snNumber;
    }

    public void setSnNumber(String snNumber) {
        this.snNumber = snNumber == null ? null : snNumber.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getPhUrl() {
		return phUrl;
	}

	public void setPhUrl(String phUrl) {
		this.phUrl = phUrl;
	}

	public List<InsurancePhoto> getInsPhotos() {
		return insPhotos;
	}

	public void setInsPhotos(List<InsurancePhoto> insPhotos) {
		this.insPhotos = insPhotos;
	}

	public int getAuReviewCount() {
		return auReviewCount;
	}

	public void setAuReviewCount(int auReviewCount) {
		this.auReviewCount = auReviewCount;
	}

	
}