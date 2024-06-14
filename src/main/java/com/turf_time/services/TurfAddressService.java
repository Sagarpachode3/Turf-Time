package com.turf_time.services;

import java.util.List;

import com.turf_time.dtos.TurfAddressDto;

public interface TurfAddressService {

	TurfAddressDto registerAddress(TurfAddressDto turfAddressDto);

	TurfAddressDto getTurfAddress(Integer turfAddressId);

	List<TurfAddressDto> getAllTurfAddresses();

	TurfAddressDto updateTurfAddress(TurfAddressDto turfAddressDto, Integer turfAddressId);

	void deleteTurfAddress(Integer turfAddressId);

}
