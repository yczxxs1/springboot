package com.google.business.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.business.dto.LocationDTO;
import com.google.business.model.Activity;
import com.google.business.model.LicenseEntity;
import com.google.business.model.UavEntity;
import com.google.business.model.User;
import com.google.business.service.ExportExcelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/export")
@Api(description="导出")
public class ExportExcelController {
	    @Autowired
		private ExportExcelService exportService;
	    
	    // ,  produces = {"application/vnd.ms-excel;charset=UTF-8"}
	    @RequestMapping(value = "/uav")@ApiOperation("导出无人机数据")
		public ResponseEntity<byte[]> exportUav(UavEntity uav) throws Exception {
				HttpHeaders headers = new HttpHeaders();
		        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
 		        headers.setContentDispositionFormData("attachment", "uav_"+Calendar.getInstance().getTimeInMillis()+".xls");
			return new ResponseEntity<byte[]> (exportService.uav(uav).toByteArray(),
	                headers, HttpStatus.CREATED);
		}
		
	    @RequestMapping(value = "/user")@ApiOperation("导出驾驶员数据")
		public ResponseEntity<byte[]> exportUser(User user) throws Exception {
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		        headers.setContentDispositionFormData("attachment", "user_"+Calendar.getInstance().getTimeInMillis()+".xls");
		return new ResponseEntity<byte[]> (exportService.user(user).toByteArray(),
                headers, HttpStatus.CREATED);
	    }
		
		@RequestMapping(value = "/license")@ApiOperation("导出证书数据")
		public ResponseEntity<byte[]> exportLicense(LicenseEntity license) throws Exception {
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		        headers.setContentDispositionFormData("attachment", "license_"+Calendar.getInstance().getTimeInMillis()+".xls");
		return new ResponseEntity<byte[]> (exportService.license(license).toByteArray(),
                headers, HttpStatus.CREATED);
	    }
		
		@RequestMapping(value = "/location")@ApiOperation("导出监控数据")
		public ResponseEntity<byte[]> exportLocation(LocationDTO locationDTO) throws Exception {
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		        headers.setContentDispositionFormData("attachment", "location_"+Calendar.getInstance().getTimeInMillis()+".xls");
		return new ResponseEntity<byte[]> (exportService.location(locationDTO).toByteArray(),
                headers, HttpStatus.CREATED);
	    }
		
		@RequestMapping(value = "/activity")@ApiOperation("导出活动数据")
		public ResponseEntity<byte[]> exportActivity(Activity activity) throws Exception {
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		        headers.setContentDispositionFormData("attachment", "activity_"+Calendar.getInstance().getTimeInMillis()+".xls");
		return new ResponseEntity<byte[]> (exportService.activity(activity).toByteArray(),
                headers, HttpStatus.CREATED);
	    }
		
}
