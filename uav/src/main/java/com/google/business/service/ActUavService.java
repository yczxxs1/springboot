package com.google.business.service;

import java.io.File;
import java.util.List;

import com.google.business.model.ActUav;

public interface ActUavService {
	void delActUav(String id);
	void updateActUav(ActUav actUav);
	List<ActUav> getActUavList(ActUav actUav);
	List<ActUav> getAUList(ActUav actUav);
	ActUav getDetail(ActUav actUav);
	void createActUav(ActUav actUav, List<File> files) throws Exception;
	void review(ActUav actUav);
}
