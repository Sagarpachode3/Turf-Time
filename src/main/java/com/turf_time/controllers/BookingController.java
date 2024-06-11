/*
 * package com.turf_time.controllers;
 * 
 * import com.turf_time.dtos.BookingDto; import
 * com.turf_time.payloads.ApiResponse; import
 * com.turf_time.services.BookingService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.validation.annotation.Validated; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import java.util.List;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/bookings") public class BookingController {
 * 
 * private final BookingService bookingService;
 * 
 * @Autowired public BookingController(BookingService bookingService) {
 * this.bookingService = bookingService; }
 * 
 * @PostMapping("/book") public ResponseEntity<BookingDto>
 * createBooking(@Validated @RequestBody BookingDto bookingDto) { BookingDto
 * createdBooking = bookingService.createBooking(bookingDto); return new
 * ResponseEntity<>(createdBooking, HttpStatus.CREATED); }
 * 
 * @PutMapping("/update/{bookingId}") public ResponseEntity<BookingDto>
 * updateBooking(@PathVariable Integer bookingId, @Validated @RequestBody
 * BookingDto bookingDto) { BookingDto updatedBooking =
 * bookingService.updateBooking(bookingId, bookingDto); return new
 * ResponseEntity<>(updatedBooking, HttpStatus.OK); }
 * 
 * @DeleteMapping("/delete/{bookingId}") public ResponseEntity<ApiResponse>
 * deleteBooking(@PathVariable Integer bookingId) {
 * bookingService.deleteBooking(bookingId); return new
 * ResponseEntity<ApiResponse>(new ApiResponse("Booking deleted",
 * true),HttpStatus.OK); }
 * 
 * @GetMapping("getbooking/{bookingId}") public ResponseEntity<BookingDto>
 * getBookingById(@PathVariable Integer bookingId) { BookingDto booking =
 * bookingService.getBookingById(bookingId); return new
 * ResponseEntity<>(booking, HttpStatus.OK); }
 * 
 * @GetMapping public ResponseEntity<List<BookingDto>> getAllBookings() {
 * List<BookingDto> bookings = bookingService.getAllBookings(); return new
 * ResponseEntity<>(bookings, HttpStatus.OK); }
 * 
 * @GetMapping("/turf/{turfId}") public ResponseEntity<List<BookingDto>>
 * getBookingsByTurfId(@PathVariable Integer turfId) { List<BookingDto> bookings
 * = bookingService.getBookingsByTurfId(turfId); return new
 * ResponseEntity<>(bookings, HttpStatus.OK); }
 * 
 * @GetMapping("/user/{userId}") public ResponseEntity<List<BookingDto>>
 * getBookingsByUserId(@PathVariable Integer userId) { List<BookingDto> bookings
 * = bookingService.getBookingsByUserId(userId); return new
 * ResponseEntity<>(bookings, HttpStatus.OK); } }
 */