package com.google.business.model;

import java.util.Date;

public class SaleinfoPhotoEntity {
    private String id;

    private String saleinfoId;

    private String saleinfoPhoto;

    private Date creatDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSaleinfoId() {
        return saleinfoId;
    }

    public void setSaleinfoId(String saleinfoId) {
        this.saleinfoId = saleinfoId == null ? null : saleinfoId.trim();
    }

    public String getSaleinfoPhoto() {
        return saleinfoPhoto;
    }

    public void setSaleinfoPhoto(String saleinfoPhoto) {
        this.saleinfoPhoto = saleinfoPhoto == null ? null : saleinfoPhoto.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}