package com.turf_time.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf_time.dtos.TurfDto;
import com.turf_time.entities.Turf;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.TurfRepository;
import com.turf_time.services.TurfServices;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TurfServiceImpl implements TurfServices {

	private TurfRepository turfRepository;
	private ModelMapper modelMapper;

	@Autowired
	public TurfServiceImpl(TurfRepository turfRepository, ModelMapper modelMapper) {
		super();
		this.turfRepository = turfRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public TurfDto createTurf(TurfDto turfDto) {
		Turf turf = modelMapper.map(turfDto, Turf.class);
		Turf savedTurf = turfRepository.save(turf);
		return modelMapper.map(savedTurf, TurfDto.class);
	}

	@Override
	public TurfDto updateTurf(TurfDto turfDto, Integer turfId) {
		Turf turf = turfRepository.findById(turfId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "turf Id", turfId));
		
		turf.setTurfName(turfDto.getTurfName());
		turf.setCountry(turfDto.getCountry());
	    turf.setState(turfDto.getState());
	    turf.setDistrict(turfDto.getDistrict());
	    turf.setTahsil(turfDto.getTahsil());
	    turf.setCity(turfDto.getCity());
	    turf.setLocalAddress(turfDto.getLocalAddress());
	    turf.setPricePerHour(turfDto.getPricePerHour());
	    turf.setAvailableFrom(turfDto.getAvailableFrom());
	    turf.setAvailableTo(turfDto.getAvailableTo());
	    turf.setAvailable(turfDto.isAvailable());
	    turf.setFeatures(turfDto.getFeatures());
	    turf.setType(turfDto.getType());
	    turf.setSize(turfDto.getSize());
		
		Turf updatedTurf = turfRepository.save(turf);
		TurfDto dto = modelMapper.map(updatedTurf, TurfDto.class);
		return dto;
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
	public List<TurfDto> getTurfByManagerId(Integer managerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTurf(Integer turfId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TurfDto> getTurfByName(String turfName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TurfDto> getTurfByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TurfDto> getTurfByState(String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TurfDto> getTurfByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TurfDto> getTurfByTahsil(String tahsil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TurfDto> getTurfByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
