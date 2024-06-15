package com.turf_time.services.impl;

import com.turf_time.dtos.TurfTypeDto;
import com.turf_time.entities.TurfType;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.TurfTypeRepository;
import com.turf_time.services.TurfTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TurfTypeServiceImpl implements TurfTypeService {

	private final TurfTypeRepository turfTypeRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public TurfTypeServiceImpl(TurfTypeRepository turfTypeRepository, ModelMapper modelMapper) {
		this.turfTypeRepository = turfTypeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public TurfTypeDto createTurfType(TurfTypeDto turfTypeDto) {
		TurfType turfType = modelMapper.map(turfTypeDto, TurfType.class);
		TurfType savedTurfType = turfTypeRepository.save(turfType);
		return modelMapper.map(savedTurfType, TurfTypeDto.class);
	}

	@Override
	public TurfTypeDto getTurfTypeById(Integer id) {
		TurfType turfType = turfTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TurfType", "id", id));
		return modelMapper.map(turfType, TurfTypeDto.class);
	}

	@Override
	public List<TurfTypeDto> getAllTurfTypes() {
		List<TurfType> turfTypes = turfTypeRepository.findAll();
		return turfTypes.stream().map(turfType -> modelMapper.map(turfType, TurfTypeDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public TurfTypeDto updateTurfType(Integer id, TurfTypeDto turfTypeDto) {
		TurfType turfType = turfTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TurfType", "id", id));
		turfType.setTurfTypeName(turfTypeDto.getTurfTypeName());
		TurfType updatedTurfType = turfTypeRepository.save(turfType);

		return modelMapper.map(updatedTurfType, TurfTypeDto.class);
	}

	@Override
	public void deleteTurfType(Integer id) {
		TurfType turfType = turfTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TurfType", "id", id));
		turfTypeRepository.delete(turfType);
	}
}
