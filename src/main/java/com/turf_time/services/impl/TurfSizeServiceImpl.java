package com.turf_time.services.impl;

import com.turf_time.dtos.TurfSizeDto;
import com.turf_time.entities.TurfSize;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.TurfSizeRepository;
import com.turf_time.services.TurfSizeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TurfSizeServiceImpl implements TurfSizeService {

	@Autowired
	private TurfSizeRepository turfSizeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TurfSizeDto createTurfSize(TurfSizeDto turfSizeDto) {

		TurfSize turfSize = modelMapper.map(turfSizeDto, TurfSize.class);
		TurfSize savedTurfSize = turfSizeRepository.save(turfSize);

		return modelMapper.map(savedTurfSize, TurfSizeDto.class);
	}

	@Override
	public TurfSizeDto getTurfSizeById(Integer id) {
		TurfSize turfSize = turfSizeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TurfSize", "id", id));

		return modelMapper.map(turfSize, TurfSizeDto.class);
	}

	@Override
	public List<TurfSizeDto> getAllTurfSizes() {
		List<TurfSize> turfSizes = turfSizeRepository.findAll();

		return turfSizes.stream().map(turfSize -> modelMapper.map(turfSize, TurfSizeDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public TurfSizeDto updateTurfSize(Integer id, TurfSizeDto turfSizeDto) {
		TurfSize turfSize = turfSizeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TurfSize", "id", id));

		turfSize.setTurfSize(turfSizeDto.getTurfSize());
		TurfSize updatedTurfSize = turfSizeRepository.save(turfSize);

		return modelMapper.map(updatedTurfSize, TurfSizeDto.class);
	}

	@Override
	public void deleteTurfSize(Integer id) {
		TurfSize turfSize = turfSizeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TurfSize", "id", id));
		turfSizeRepository.delete(turfSize);
	}
}
