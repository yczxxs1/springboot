package com.netflix.business.domain;
//聚合根
public class LikeUp {
    private String likeId;

    private String likeObjectId;

    private String likeUserId;

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId == null ? null : likeId.trim();
    }

    public String getLikeObjectId() {
        return likeObjectId;
    }

    public void setLikeObjectId(String likeObjectId) {
        this.likeObjectId = likeObjectId == null ? null : likeObjectId.trim();
    }

    public String getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(String likeUserId) {
        this.likeUserId = likeUserId == null ? null : likeUserId.trim();
    }

    
    
	public LikeUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeUp(String likeObjectId, String likeUserId) {
		super();
		this.likeObjectId = likeObjectId;
		this.likeUserId = likeUserId;
	}
    
    
}