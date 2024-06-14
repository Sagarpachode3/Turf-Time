package com.turf_time.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf_time.dtos.TurfAddressDto;
import com.turf_time.entities.TurfAddress;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.TurfAddressRepository;
import com.turf_time.services.TurfAddressService;

@Service
public class TurdAddressServiceImpl implements TurfAddressService {

	private TurfAddressRepository turfAddressRepository;

	private ModelMapper modelMapper;

	@Autowired
	public TurdAddressServiceImpl(TurfAddressRepository turfAddressRepository, ModelMapper modelMapper) {
		super();
		this.turfAddressRepository = turfAddressRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public TurfAddressDto registerAddress(TurfAddressDto turfAddressDto) {

		TurfAddress turfAddress = modelMapper.map(turfAddressDto, TurfAddress.class);
		TurfAddress savedAddress = turfAddressRepository.save(turfAddress);

		return modelMapper.map(savedAddress, TurfAddressDto.class);
	}

	@Override
	public TurfAddressDto getTurfAddress(Integer turfAddressId) {

		TurfAddress turfAddress = turfAddressRepository.findById(turfAddressId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf Address", "id", turfAddressId));

		return modelMapper.map(turfAddress, TurfAddressDto.class);
	}

	@Override
	public List<TurfAddressDto> getAllTurfAddresses() {
		
		List<TurfAddress> list = turfAddressRepository.findAll();
		
		return list.stream().map(addrs -> modelMapper.map(addrs, TurfAddressDto.class)).collect(Collectors.toList());
	}

	@Override
	public TurfAddressDto updateTurfAddress(TurfAddressDto turfAddressDto, Integer turfAddressId) {

		TurfAddress turfAddress = turfAddressRepository.findById(turfAddressId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf Address", "id", turfAddressId));

		turfAddress.setCountry(turfAddressDto.getCountry());
		turfAddress.setState(turfAddressDto.getState());
		turfAddress.setDistrict(turfAddressDto.getDistrict());
		turfAddress.setTahsil(turfAddressDto.getTahsil());
		turfAddress.setCity(turfAddressDto.getCity());
		turfAddress.setLocalAddress(turfAddressDto.getLocalAddress());

		TurfAddress updatedAddress = turfAddressRepository.save(turfAddress);

		return modelMapper.map(updatedAddress, TurfAddressDto.class);
	}

	@Override
	public void deleteTurfAddress(Integer turfAddressId) {
		
		TurfAddress turfAddress = turfAddressRepository.findById(turfAddressId)
				.orElseThrow(() -> new ResourceNotFoundException("Turf Address", "id", turfAddressId));
		
		turfAddressRepository.delete(turfAddress);
	
	}

}
