/*
 * package com.turf_time.controllers;
 * 
 * import com.turf_time.dtos.PaymentDto; import
 * com.turf_time.services.PaymentService;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.validation.annotation.Validated; import
 * org.springframework.web.bind.annotation.*;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/payments") public class PaymentController {
 * 
 * private final PaymentService paymentService;
 * 
 * @Autowired public PaymentController(PaymentService paymentService) {
 * this.paymentService = paymentService; }
 * 
 * @PostMapping("/pay") public ResponseEntity<PaymentDto>
 * createPayment(@Validated @RequestBody PaymentDto paymentDto) { PaymentDto
 * createdPayment = paymentService.createPayment(paymentDto); return new
 * ResponseEntity<>(createdPayment, HttpStatus.CREATED); }
 * 
 * @PutMapping("/update/{paymentId}") public ResponseEntity<PaymentDto>
 * updatePayment(@PathVariable Integer paymentId,
 * 
 * @Validated @RequestBody PaymentDto paymentDto) { PaymentDto updatedPayment =
 * paymentService.updatePayment(paymentId, paymentDto); return new
 * ResponseEntity<>(updatedPayment, HttpStatus.OK); }
 * 
 * @GetMapping("/getpayment/{paymentId}") public ResponseEntity<PaymentDto>
 * getPaymentById(@PathVariable Integer paymentId) { PaymentDto payment =
 * paymentService.getPaymentById(paymentId); return new
 * ResponseEntity<>(payment, HttpStatus.OK); }
 * 
 * @DeleteMapping("/delete/{paymentId}") public ResponseEntity<Void>
 * deletePayment(@PathVariable Integer paymentId) {
 * paymentService.deletePayment(paymentId); return new
 * ResponseEntity<>(HttpStatus.NO_CONTENT); } }
 */