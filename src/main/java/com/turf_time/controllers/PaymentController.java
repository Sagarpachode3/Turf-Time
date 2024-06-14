package com.turf_time.controllers;

import com.turf_time.dtos.PaymentDto;
import com.turf_time.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	private final PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/processpayment")
	public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto) {
		PaymentDto createdPayment = paymentService.createPayment(paymentDto);
		return ResponseEntity.ok(createdPayment);
	}

	@GetMapping("/get/{paymentId}")
	public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Integer paymentId) {
		PaymentDto payment = paymentService.getPaymentById(paymentId);
		return ResponseEntity.ok(payment);
	}

	@GetMapping("/")
	public ResponseEntity<List<PaymentDto>> getAllPayments() {
		List<PaymentDto> payments = paymentService.getAllPayments();
		return ResponseEntity.ok(payments);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<PaymentDto> updatePayment(@RequestBody PaymentDto paymentDto,
			@PathVariable Integer paymentId) {
		PaymentDto updatedPayment = paymentService.updatePayment(paymentId, paymentDto);
		return ResponseEntity.ok(updatedPayment);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable Integer paymentId) {
		paymentService.deletePayment(paymentId);
		return ResponseEntity.noContent().build();
	}
}
