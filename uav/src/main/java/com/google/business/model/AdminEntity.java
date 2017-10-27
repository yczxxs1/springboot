package com.google.business.model;

import java.util.Date;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class AdminEntity {
    private String id;

    @NotBlank(groups=CREATE.class)
    private String name;

    private String password;

    @NotBlank(groups=CREATE.class)
    private String nikeName;

    @NotBlank(groups=CREATE.class)
    private String sex;

    @NotBlank(groups=CREATE.class)
    private String dept;

    private String avatar;

    private String policeNumber;

    @NotBlank(groups=CREATE.class)
    private String areaId;
    
    private String areaName;

    private String email;

    @NotBlank(groups=CREATE.class)
    private String phone;

    private String roleId;
    
    private String roleName;

    private Date createDate;

    private Date lastLoginDate;

    private String terminalAccess;
    
    @DateTimeFormat(iso=ISO.DATE)  
    private Date effectiveDate;
    
    @NotBlank(groups=CREATE.class)
    private String status;
    
    private String areaFather;
    
    private String agencyId;

    @NotBlank(groups=CREATE.class)
    private String modelId;
    
    private String resetStatus;
    
    public String getResetStatus() {
		return resetStatus;
	}

	public void setResetStatus(String resetStatus) {
		this.resetStatus = resetStatus;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getAreaFather() {
		return areaFather;
	}

	public void setAreaFather(String areaFather) {
		this.areaFather = areaFather;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName == null ? null : nikeName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getPoliceNumber() {
        return policeNumber;
    }

    public void setPoliceNumber(String policeNumber) {
        this.policeNumber = policeNumber == null ? null : policeNumber.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
    
    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getTerminalAccess() {
        return terminalAccess;
    }

    public void setTerminalAccess(String terminalAccess) {
        this.terminalAccess = terminalAccess == null ? null : terminalAccess.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
    
	public interface CREATE{};
}