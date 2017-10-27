package com.google.business.model;

import java.util.Date;

public class MessageEntity {
    private String id;

    private String title;

    private String content;

    private String messagetype;

    private Date happentime;

    @SuppressWarnings("unused")
	private Date currenttime;

    private String flag;
    
    private String userId;
    
    private int urlFlag;

    public int getUrlFlag() {
		return urlFlag;
	}

	public void setUrlFlag(int urlFlag) {
		this.urlFlag = urlFlag;
	}

	public MessageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageEntity(String title, String content, String messagetype, Date happentime, String flag,
			String userId) {
		super();
		this.title = title;
		this.content = content;
		this.messagetype = messagetype;
		this.happentime = happentime;
		this.flag = flag;
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype == null ? null : messagetype.trim();
    }

    public Date getHappentime() {
        return happentime;
    }

    public void setHappentime(Date happentime) {
        this.happentime = happentime;
    }

    public Date getCurrenttime() {
        return new Date();
    }

    public void setCurrenttime(Date currenttime) {
        this.currenttime = currenttime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}