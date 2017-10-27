package com.google.business.conversion;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.business.dto.ActivityDTO;
import com.google.business.model.Activity;

@Component
public class ActivityConversion {

	@Autowired
	private ModelMapper modelMapper;

	public ActivityDTO converToDTO(Activity activity) {
		ActivityDTO activityDTO = modelMapper.map(activity, ActivityDTO.class);
		String areaIds = activity.getAreaId();
		String[] areaId = null;
		if (!StringUtils.isEmpty(areaIds)) {
			areaId = areaIds.split(",");
		}
		activityDTO.setAreaId(areaId);
		return activityDTO;
	}

}
