package com.turf_time.services;

import com.turf_time.dtos.ActiveStatusDto;

public interface ActiveStatusService {

	ActiveStatusDto createActiveStatus(ActiveStatusDto activeStatusDto);

	ActiveStatusDto getActiveStatus(Integer ActiveStatusId);

	ActiveStatusDto updateActiveStatus(ActiveStatusDto activeStatusDto, Integer ActiveStatusId);
	
	void deleteActiveStatus(Integer ActiveStatusId);

}
