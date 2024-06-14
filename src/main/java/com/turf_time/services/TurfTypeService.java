package com.turf_time.services;

import com.turf_time.dtos.TurfTypeDto;
import java.util.List;

public interface TurfTypeService {
	
	TurfTypeDto createTurfType(TurfTypeDto turfTypeDto);
	
	TurfTypeDto getTurfTypeById(Integer id);
	
	List<TurfTypeDto> getAllTurfTypes();

	TurfTypeDto updateTurfType(Integer id, TurfTypeDto turfTypeDto);

	void deleteTurfType(Integer id);
}
