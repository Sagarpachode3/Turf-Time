package com.turf_time.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf_time.dtos.TurfDto;
import com.turf_time.entities.Turf;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.ManagerRepository;
import com.turf_time.repositories.TurfRepository;
import com.turf_time.services.TurfService;

import jakarta.transaction.Transactional;

@Service("turfService")
@Transactional
public class TurfServiceImpl implements TurfService {

	private TurfRepository turfRepository;
	//private ManagerRepository managerRepository;
	private ModelMapper modelMapper;

	@Autowired
	public TurfServiceImpl(TurfRepository turfRepository, ModelMapper modelMapper,
			ManagerRepository managerRepository) {
		super();
		this.turfRepository = turfRepository;
		this.modelMapper = modelMapper;
		//this.managerRepository = managerRepository;
	}

	@Override
	public TurfDto registerTurf(TurfDto turfDto) {
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
		Turf turf = turfRepository.findById(turfId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "turf Id", turfId));
		return this.modelMapper.map(turf, TurfDto.class);
	}

	@Override
	public List<TurfDto> getAllTurfs() {
		List<Turf> allTurfs = turfRepository.findAll();
		List<TurfDto> turfDtos = allTurfs.stream().map(turf -> modelMapper.map(turf, TurfDto.class))
				.collect(Collectors.toList());
		return turfDtos;
	}

	@Override
	public List<TurfDto> getTurfByManagerId(Integer managerId) {
		List<Turf> byManager_ManagerId = turfRepository.findByManager_ManagerId(managerId);
		return byManager_ManagerId.stream().map(turf -> modelMapper.map(turf, TurfDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteTurf(Integer turfId) {
		Turf turf = turfRepository.findById(turfId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf", "turf Id", turfId));
		turfRepository.delete(turf);
	}

	@Override
	public List<TurfDto> getTurfByName(String turfName) {
		List<Turf> turfs = turfRepository.findByTurfNameContaining(turfName);
		return turfs.stream().map(turf -> modelMapper.map(turf, TurfDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<TurfDto> getTurfByCountry(String country) {
		List<Turf> turfs = turfRepository.findByCountry(country);
		return turfs.stream().map(turf -> modelMapper.map(turf, TurfDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<TurfDto> getTurfByState(String state) {
		List<Turf> turfs = turfRepository.findByState(state);
		return turfs.stream().map(turf -> modelMapper.map(turf, TurfDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<TurfDto> getTurfByDistrict(String district) {
		List<Turf> turfs = turfRepository.findByDistrict(district);
		return turfs.stream().map(turf -> modelMapper.map(turf, TurfDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<TurfDto> getTurfByTahsil(String tahsil) {
		List<Turf> turfs = turfRepository.findByTahsil(tahsil);
		return turfs.stream().map(turf -> modelMapper.map(turf, TurfDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<TurfDto> getTurfByCity(String city) {
		List<Turf> turfs = turfRepository.findByCity(city);
		return turfs.stream().map(turf -> modelMapper.map(turf, TurfDto.class)).collect(Collectors.toList());
	}

}
