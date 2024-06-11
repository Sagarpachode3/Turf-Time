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
 * import com.turf_time.dtos.PasswordResetDto; import
 * com.turf_time.dtos.UserDto; import com.turf_time.payloads.ApiResponse; import
 * com.turf_time.services.UserService;
 * 
 * import jakarta.validation.Valid;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/users") public class UserController {
 * 
 * private UserService userService;
 * 
 * @Autowired public UserController(UserService userService) { this.userService
 * = userService; }
 * 
 * // POST - register User
 * 
 * @PostMapping("/register") public ResponseEntity<UserDto>
 * registerUser(@Valid @RequestBody UserDto userDto) { UserDto createUser =
 * userService.registerUser(userDto); return new ResponseEntity<>(createUser,
 * HttpStatus.CREATED); }
 * 
 * // PUT - Update User
 * 
 * @PutMapping("/update/{userId}") public ResponseEntity<UserDto>
 * updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId)
 * { UserDto updatedUser = this.userService.updateUser(userDto, userId); return
 * ResponseEntity.ok(updatedUser);
 * 
 * }
 * 
 * // GET - Get User
 * 
 * @GetMapping("/{userId}") public ResponseEntity<UserDto>
 * getUserById(@PathVariable Integer userId) { UserDto userById =
 * this.userService.getUserById(userId); return ResponseEntity.ok(userById); }
 * 
 * //GET - get all users List
 * 
 * @GetMapping("/") public ResponseEntity<List<UserDto>> getAllUsers(){ return
 * ResponseEntity.ok(this.userService.getAllUsers()); }
 * 
 * // DELETE - delete user
 * 
 * @DeleteMapping("del/{userId}") public ResponseEntity<ApiResponse>
 * deleteUser(@PathVariable Integer userId) {
 * this.userService.deleteUser(userId); return new
 * ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",
 * true), HttpStatus.OK);
 * 
 * }
 * 
 * //PUT - Reset Password
 * 
 * @PutMapping("/res-pass") public ResponseEntity<ApiResponse>
 * resetUserPass(@Valid @RequestBody PasswordResetDto passwordResetDto){
 * this.userService.updateUserPassword(passwordResetDto.getEmail(),
 * passwordResetDto.getPassword()); return new ResponseEntity<>(new
 * ApiResponse("Password changed Sucessfully!", true), HttpStatus.OK); } }
 */