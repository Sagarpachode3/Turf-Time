package com.turf_time.services.impl;

import com.turf_time.dtos.PaymentDto;
import com.turf_time.entities.Booking;
import com.turf_time.entities.Payment;
import com.turf_time.exceptions.ResourceNotFoundException;
import com.turf_time.repositories.BookingRepository;
import com.turf_time.repositories.PaymentRepository;
import com.turf_time.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

	private final PaymentRepository paymentRepository;
	private final BookingRepository bookingRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository, BookingRepository bookingRepository,
			ModelMapper modelMapper) {
		this.paymentRepository = paymentRepository;
		this.bookingRepository = bookingRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PaymentDto createPayment(PaymentDto paymentDto) {
		Payment payment = modelMapper.map(paymentDto, Payment.class);
		Booking booking = bookingRepository.findById(paymentDto.getBookingId())
				.orElseThrow(() -> new ResourceNotFoundException("Booking", "id", paymentDto.getBookingId()));

		payment.setBooking(booking);
		Payment savedPayment = paymentRepository.save(payment);

		return modelMapper.map(savedPayment, PaymentDto.class);
	}

	@Override
	public PaymentDto getPaymentById(Integer paymentId) {
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment", "id", paymentId));

		return modelMapper.map(payment, PaymentDto.class);
	}

	@Override
	public List<PaymentDto> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();

		return payments.stream().map(payment -> modelMapper.map(payment, PaymentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public PaymentDto updatePayment(Integer paymentId, PaymentDto paymentDto) {
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment", "id", paymentId));

		Booking booking = bookingRepository.findById(paymentDto.getBookingId())
				.orElseThrow(() -> new ResourceNotFoundException("Booking", "id", paymentDto.getBookingId()));

		payment.setAmount(paymentDto.getAmount());
		payment.setPaymentGatewayTransactionId(paymentDto.getPaymentGatewayTransactionId());
		payment.setStatus(paymentDto.getStatus());
		payment.setPaymentMethod(paymentDto.getPaymentMethod());
		payment.setBooking(booking);

		Payment updatedPayment = paymentRepository.save(payment);

		return modelMapper.map(updatedPayment, PaymentDto.class);
	}

	@Override
	public void deletePayment(Integer paymentId) {
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment", "id", paymentId));
		paymentRepository.delete(payment);
	}
}
