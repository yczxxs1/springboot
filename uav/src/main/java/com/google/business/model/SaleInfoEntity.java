package com.google.business.model;

import java.util.Date;
import java.util.List;

public class SaleInfoEntity {
    private String id;
    
    private String name;

    private String phone;

    private String ownerid;

    private String regstatus;

    private String sn;

    private String vendorid;

    private Date saletime;
    
    private String uavModel;
    
    private String ownerType;
    
    private String factoryModelId;

    private String factoryname;
    
    private String uavModelName;
    
    private String photoUrl;
    
    private String areaId;

    private String factModelName;

    private List<SaleinfoPhotoEntity> saleinfoPhotoEntity;

    public String getFactModelName() {
		return factModelName;
	}

	public void setFactModelName(String factModelName) {
		this.factModelName = factModelName;
	}

    public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getUavModelName() {
		return uavModelName;
	}

	public void setUavModelName(String uavModelName) {
		this.uavModelName = uavModelName;
	}


    public String getFactoryname() {

		return factoryname;
	}

	public void setFactoryname(String factoryname) {
		this.factoryname = factoryname;
	}

	public String getFactoryModelId() {
		return factoryModelId;
	}

	public void setFactoryModelId(String factoryModelId) {
		this.factoryModelId = factoryModelId;
	}

	public String getUavModel() {
		return uavModel;
	}

	public void setUavModel(String uavModel) {
		this.uavModel = uavModel;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid == null ? null : ownerid.trim();
    }

    public String getRegstatus() {
        return regstatus;
    }

    public void setRegstatus(String regstatus) {
        this.regstatus = regstatus == null ? null : regstatus.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid == null ? null : vendorid.trim();
    }

    public Date getSaletime() {
        return saletime;
    }

    public void setSaletime(Date saletime) {
        this.saletime = saletime;
    }

	public List<SaleinfoPhotoEntity> getSaleinfoPhotoEntity() {
		return saleinfoPhotoEntity;
	}

	public void setSaleinfoPhotoEntity(List<SaleinfoPhotoEntity> saleinfoPhotoEntity) {
		this.saleinfoPhotoEntity = saleinfoPhotoEntity;
	}
    
}