package com.google.business.model;

import java.util.Date;
import java.util.List;

public class UavHistoryEntity {
    private Long id;

    private String snNumber;

    private String status;

    private Date statusChangeDate;
    
    private String saleId;
    
    private String transferId;

    private List<UavTransferEntity> uavTransferEntity;
    
    private List<SaleInfoEntity> saleInfoEntity;
   
    private User loginOrWriteOffInfo;
    
	public User getLoginOrWriteOffInfo() {
		return loginOrWriteOffInfo;
	}

	public void setLoginOrWriteOffInfo(User loginOrWriteOffInfo) {
		this.loginOrWriteOffInfo = loginOrWriteOffInfo;
	}

	private String historyBelongId;
    
	public String getHistoryBelongId() {
		return historyBelongId;
	}

	public void setHistoryBelongId(String historyBelongId) {
		this.historyBelongId = historyBelongId;
	}


	public List<UavTransferEntity> getUavTransferEntity() {
		return uavTransferEntity;
	}

	public void setUavTransferEntity(List<UavTransferEntity> uavTransferEntity) {
		this.uavTransferEntity = uavTransferEntity;
	}

	public List<SaleInfoEntity> getSaleInfoEntity() {
		return saleInfoEntity;
	}

	public void setSaleInfoEntity(List<SaleInfoEntity> saleInfoEntity) {
		this.saleInfoEntity = saleInfoEntity;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSnNumber() {
        return snNumber;
    }

    public void setSnNumber(String snNumber) {
        this.snNumber = snNumber == null ? null : snNumber.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(Date statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }
}