package com.google.business.service;

import java.io.ByteArrayOutputStream;

import com.google.business.dto.LocationDTO;
import com.google.business.model.Activity;
import com.google.business.model.LicenseEntity;
import com.google.business.model.UavEntity;
import com.google.business.model.User;



public interface ExportExcelService {
    public ByteArrayOutputStream uav(UavEntity uav) throws Exception;
    public ByteArrayOutputStream user(User user) throws Exception;
    public ByteArrayOutputStream license(LicenseEntity license) throws Exception;
    public ByteArrayOutputStream location(LocationDTO locationDTO) throws Exception;
    public ByteArrayOutputStream activity(Activity activity) throws Exception;

}