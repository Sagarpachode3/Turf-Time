/*
 * package com.turf_time.controllers;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.turf_time.dtos.BookingDto; import com.turf_time.dtos.ManagerDto;
 * import com.turf_time.dtos.TurfDto; import com.turf_time.dtos.UserDto; import
 * com.turf_time.payloads.ApiResponse; import
 * com.turf_time.services.ManagerService;
 * 
 * import jakarta.validation.Valid;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/managers") public class ManagerController {
 * 
 * private ManagerService managerService;
 * 
 * @Autowired public ManagerController(ManagerService managerService) { super();
 * this.managerService = managerService; }
 * 
 * @PostMapping("/register") public ResponseEntity<ManagerDto>
 * registerManager(@Valid @RequestBody ManagerDto managerDto) { ManagerDto
 * registeredManager = managerService.registerManager(managerDto); return new
 * ResponseEntity<>(registeredManager, HttpStatus.CREATED); }
 * 
 * @PutMapping("/update/{managerId}") public ResponseEntity<ManagerDto>
 * updateManagerDetails(@Valid @RequestBody ManagerDto managerDto,
 * 
 * @PathVariable Integer managerId) {
 * 
 * ManagerDto updatedManagerDetails =
 * managerService.updateManagerDetails(managerId, managerDto); return new
 * ResponseEntity<>(updatedManagerDetails, HttpStatus.OK); }
 * 
 * @DeleteMapping("/delete/{managerId}") public ResponseEntity<ApiResponse>
 * deleteManager(@PathVariable Integer managerId){
 * managerService.deleteManager(managerId); return new
 * ResponseEntity<ApiResponse>(new
 * ApiResponse("Manager deleted Successfully",true), HttpStatus.OK); }
 * 
 * @GetMapping("/getturf/{managerId}/turfs") public
 * ResponseEntity<List<TurfDto>> getTurfsByManagerId(@PathVariable Integer
 * managerId) { List<TurfDto> turfsByManagerId =
 * managerService.getTurfsByManagerId(managerId); return new
 * ResponseEntity<>(turfsByManagerId, HttpStatus.OK); }
 * 
 * @PutMapping("/updateturf/{managerId}/turfs/{turfId}") public
 * ResponseEntity<TurfDto> updateTurfDetails(@PathVariable Integer
 * managerId, @PathVariable Integer turfId,
 * 
 * @Valid @RequestBody TurfDto turfDto) {
 * 
 * TurfDto updatedTurfDetails = managerService.updateTurfDetails(managerId,
 * turfId, turfDto); return new ResponseEntity<>(updatedTurfDetails,
 * HttpStatus.OK); }
 * 
 * @GetMapping("/turfs/{turfId}/{managerId}/bookings") public
 * ResponseEntity<List<BookingDto>> getBookingsByTurfId(@PathVariable Integer
 * turfId,
 * 
 * @PathVariable Integer managerId) { List<BookingDto> bookingsByTurfId =
 * managerService.getBookingsByTurfId(turfId, managerId); return new
 * ResponseEntity<>(bookingsByTurfId, HttpStatus.OK); }
 * 
 * @GetMapping("/turfs/{turfId}/{managerId}/users") public
 * ResponseEntity<List<UserDto>> getUsersByTurfId(@PathVariable Integer
 * managerId,
 * 
 * @PathVariable Integer turfId) { List<UserDto> users =
 * managerService.getUsersByTurfId(turfId, managerId); return new
 * ResponseEntity<>(users, HttpStatus.OK); } }
 */