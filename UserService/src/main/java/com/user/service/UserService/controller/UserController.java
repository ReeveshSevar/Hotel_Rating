package com.user.service.UserService.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.service.UserService.entity.User;
import com.user.service.UserService.service.UserService;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
//import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
		
//  Creating User
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user)
	{
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1); 
	}
	
//  Fetching Data Of One User
	
//  @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//	@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@GetMapping("/{id}")
	@RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable Integer id)
	{	
		User user = userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	
// Creating A Common Method For Fallback For (Circuit Breaker, Retry, RateLimitor) 
	
	// This Method Will Be Executed When Requests Are Greater Then 2 In 1 Seconds
	public ResponseEntity<User> ratingHotelFallback(Integer id, Exception e)
	{
		User user = User.builder().userId(12345).email("dummy@gmail.com").name("Dummy").about("Dummy User Is Created Because Some Services Are Down").build();
		return new ResponseEntity<User>(user,HttpStatus.NOT_ACCEPTABLE);
	}
	
	

//  Fetching All Users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
}
