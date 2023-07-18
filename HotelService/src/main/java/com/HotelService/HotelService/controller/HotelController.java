package com.HotelService.HotelService.controller;

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
import com.HotelService.HotelService.entity.Hotel;
import com.HotelService.HotelService.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	// Create
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	// Fetch Single Hotel
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable Integer id)
	{
		Hotel hotel = hotelService.get(id);
		return ResponseEntity.ok(hotel);
	}

	// Fetch All Hotels
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll()
	{
		return ResponseEntity.ok(hotelService.getAll());
	}
	
	
}
