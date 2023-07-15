package com.HotelService.HotelService.service;

import java.util.List;

import com.HotelService.HotelService.entity.Hotel;

public interface HotelService {
	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel get(Integer id);
}
