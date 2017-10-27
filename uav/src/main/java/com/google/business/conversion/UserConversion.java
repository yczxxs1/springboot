package com.google.business.conversion;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.business.dto.UserDTO;
import com.google.business.model.User;

@Component
public class UserConversion {
	
	
	
    @Autowired
	private ModelMapper modelMapper;
	
	
	public UserDTO convertToDTO(User user) {
		
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		String areaIds=user.getAreaId();
		String[] areaId=null;
		if(!StringUtils.isEmpty(areaIds)){
			areaId=areaIds.split(",");
		}
		userDTO.setAreaId(areaId);
		return userDTO;
	}
}
