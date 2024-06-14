package com.turf_time.services;

import com.turf_time.dtos.TurfSizeDto;
import java.util.List;

public interface TurfSizeService {
	
	TurfSizeDto createTurfSize(TurfSizeDto turfSizeDto);
	
	TurfSizeDto getTurfSizeById(Integer id);
	
	List<TurfSizeDto> getAllTurfSizes();

	TurfSizeDto updateTurfSize(Integer id, TurfSizeDto turfSizeDto);

	void deleteTurfSize(Integer id);
}
