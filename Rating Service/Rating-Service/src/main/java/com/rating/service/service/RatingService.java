package com.rating.service.service;

import java.util.List;

import com.rating.service.entity.Rating;

public interface RatingService {
	
	Rating create(Rating rating);
	
	List<Rating> getAll();
	
	List<Rating> getRatingByUserId(Integer is);
	
	List<Rating> getRatingByHotelId(Integer id);
	
}
