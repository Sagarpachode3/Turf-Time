package com.turf_time.services;

import com.turf_time.dtos.PaymentDto;
import java.util.List;

public interface PaymentService {
	
	PaymentDto createPayment(PaymentDto paymentDto);
	
	PaymentDto getPaymentById(Integer id);
	
	List<PaymentDto> getAllPayments();

	PaymentDto updatePayment(Integer id, PaymentDto paymentDto);

	void deletePayment(Integer id);
}
