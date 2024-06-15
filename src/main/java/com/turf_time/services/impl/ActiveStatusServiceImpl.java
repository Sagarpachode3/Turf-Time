package com.turf_time.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turf_time.dtos.ActiveStatusDto;
import com.turf_time.entities.ActiveStatus;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.ActiveStatusRepository;
import com.turf_time.services.ActiveStatusService;

@Service
@Transactional
public class ActiveStatusServiceImpl implements ActiveStatusService {

	private ActiveStatusRepository activeStatusRepository;

	private ModelMapper modelMapper;

	@Autowired
	public ActiveStatusServiceImpl(ActiveStatusRepository activeStatusRepository, ModelMapper modelMapper) {
		super();
		this.activeStatusRepository = activeStatusRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ActiveStatusDto createActiveStatus(ActiveStatusDto activeStatusDto) {

		ActiveStatus status = modelMapper.map(activeStatusDto, ActiveStatus.class);
		ActiveStatus savedStatus = activeStatusRepository.save(status);

		return modelMapper.map(savedStatus, ActiveStatusDto.class);
	}

	@Override
	public ActiveStatusDto getActiveStatus(Integer ActiveStatusId) {
		ActiveStatus activeStatus = activeStatusRepository.findById(ActiveStatusId)
				.orElseThrow(() -> new ResourceNotFoundException("ActiveStatus", "id", ActiveStatusId));

		return modelMapper.map(activeStatus, ActiveStatusDto.class);
	}

	@Override
	public ActiveStatusDto updateActiveStatus(ActiveStatusDto activeStatusDto, Integer ActiveStatusId) {

		ActiveStatus activeStatus = activeStatusRepository.findById(ActiveStatusId)
				.orElseThrow(() -> new ResourceNotFoundException("ActiveStatus", "id", ActiveStatusId));

		activeStatus.setStatusName(activeStatusDto.getStatusName());
		ActiveStatus savedStatus = activeStatusRepository.save(activeStatus);
		
		return modelMapper.map(savedStatus, ActiveStatusDto.class);
	}

	@Override
	public void deleteActiveStatus(Integer ActiveStatusId) {
		
		ActiveStatus activeStatus = activeStatusRepository.findById(ActiveStatusId)
				.orElseThrow(() -> new ResourceNotFoundException("ActiveStatus", "id", ActiveStatusId));
		
		activeStatusRepository.delete(activeStatus);

	}

}
