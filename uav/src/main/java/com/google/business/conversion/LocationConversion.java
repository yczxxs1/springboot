package com.google.business.conversion;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.business.dto.LocationDTO;
import com.google.business.form.LocationForm;

@Component
public class LocationConversion {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public LocationDTO converToDTO(LocationForm locationForm) {
		LocationDTO locationDTO = modelMapper.map(locationForm, LocationDTO.class);
		String areaIds = locationForm.getAreaId();
		String[] areaId = null;
		if (!StringUtils.isEmpty(areaIds)) {
			areaId = areaIds.split(",");
		}
		locationDTO.setAreaId(areaId);
		return locationDTO;
	}

}
