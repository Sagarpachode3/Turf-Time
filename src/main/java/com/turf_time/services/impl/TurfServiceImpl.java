package com.turf_time.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.turf_time.dtos.TurfDto;
import com.turf_time.entities.Turf;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.ManagerRepository;
import com.turf_time.repositories.TurfRepository;
import com.turf_time.services.TurfService;

public class TurfServiceImpl implements TurfService {

	private TurfRepository turfRepository;
	private ManagerRepository managerRepository;
	private ModelMapper modelMapper;

	@Autowired
	public TurfServiceImpl(TurfRepository turfRepository, ManagerRepository managerRepository, ModelMapper modelMapper) {
		super();
		this.turfRepository = turfRepository;
		this.managerRepository=managerRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public TurfDto registerTurf(Integer managerId, TurfDto turfDto) {
		
		// Checking if the turf already exists for the given manager
		turfRepository.findByTurfNameAndManager_ManagerId(turfDto.getTurfName(), managerId)
		.ifPresent(existingTurf -> {
			throw new IllegalArgumentException("Turf with the same name already exists for the same manager.");
		});

		Turf turf = modelMapper.map(turfDto, Turf.class);
		turf.setManager(managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager","managerId", managerId)));

		Turf savedTurf = turfRepository.save(turf);

		return modelMapper.map(savedTurf, TurfDto.class);
	}

	@Override
	public TurfDto updateTurf(TurfDto turfDto, Integer turfId) {
		Turf turf = turfRepository.findById(turfId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "turf Id", turfId));
		return null;
	}

	@Override
	public TurfDto getTurfByTurfId(Integer turfId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TurfDto> getAllTurfs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTurf(Integer turfId) {
		// TODO Auto-generated method stub

	}

}
