package com.rahul.app.api.service.impl;

import java.time.LocalTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.rahul.app.api.response.CurrentTimeResponseObject;
import com.rahul.app.api.service.CurrentTimeService;

/**
 * @author Rahul
 *
 */
@Service
public class CurrentTimeServiceImpl implements CurrentTimeService{

	@Override
	public CurrentTimeResponseObject getCurrentTime() {
		
		CurrentTimeResponseObject response = new CurrentTimeResponseObject();
		LocalTime localDateTime = LocalTime.now(ZoneOffset.UTC);
		response.setCurrentTime(localDateTime);
		return response;
	}
	
	

}
