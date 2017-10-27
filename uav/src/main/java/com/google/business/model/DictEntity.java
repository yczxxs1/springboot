package com.google.business.model;

import java.util.Date;

public class DictEntity {
    /** null */
    private String id;

    /** null */
    private String type;

    /** null */
    private String value;

    /** null */
    private String label;

    /** null */
    private Date createDate;

    /** null */
    private String description;

    /**
     *
     * 获取  null
     *
     * @return  id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * 设置  null
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * 设置  null
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * 设置  null
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * 设置  null
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     *
     * 获取  null
     *
     * @return  createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *
     * 设置  null
     *
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     *
     * 获取  null
     *
     * @return  description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * 设置  null
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}