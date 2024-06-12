
package com.turf_time.services;

import java.util.List;

import com.turf_time.dtos.TurfDto;

public interface TurfService {

	TurfDto registerTurf(Integer managerId, TurfDto turfDto);

	TurfDto updateTurf(TurfDto turfDto, Integer turfId);

	TurfDto getTurfByTurfId(Integer turfId);

	List<TurfDto> getAllTurfs();

	void deleteTurf(Integer turfId);

}
