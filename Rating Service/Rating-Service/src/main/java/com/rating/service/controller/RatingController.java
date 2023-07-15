package com.rating.service.controller;

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
import com.rating.service.entity.Rating;
import com.rating.service.serviceImpl.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingServiceImpl service;
	
	
//  For Creating Rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
	}
	
	
//  For Getting All Ratings
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings()
	{
		return ResponseEntity.ok(service.getAll());
	}
	
//  For Fetching Rating Based On UserId
	@GetMapping("/users/{id}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer id)
	{
		return ResponseEntity.ok(service.getRatingByUserId(id));
	}
	
//  For Fetching Rating Based On HotelId
	@GetMapping("/hotels/{id}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Integer id)
	{
		return ResponseEntity.ok(service.getRatingByHotelId(id));
	}
}
