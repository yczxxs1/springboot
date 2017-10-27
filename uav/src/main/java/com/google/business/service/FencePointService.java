package com.google.business.service;

import java.util.List;
import com.google.business.model.FenceInfo2;

public interface FencePointService {
	public List<FenceInfo2> getFencePoint(String userId,Double latitude, Double longitude);
}
