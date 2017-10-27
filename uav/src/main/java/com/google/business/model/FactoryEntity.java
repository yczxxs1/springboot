package com.google.business.model;

import java.util.List;

public class FactoryEntity {
    /** null */
    private String id;

    /** null */
    private String name;

    private List<UavModelEntity> uavModelList;
    
    public List<UavModelEntity> getUavModelList() {
		return uavModelList;
	}

	public void setUavModelList(List<UavModelEntity> uavModelList) {
		this.uavModelList = uavModelList;
	}

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
     * @return  name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * 设置  null
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}