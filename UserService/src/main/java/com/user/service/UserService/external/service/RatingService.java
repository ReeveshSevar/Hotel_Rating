package com.user.service.UserService.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.user.service.UserService.entity.Rating;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@PostMapping("/ratings")
	public Rating createRating(Rating values);
	
	@PutMapping("/ratings/ratingId")
	public Rating updateRating(@PathVariable Integer ratingId, Rating rating);
	
	@DeleteMapping("/ratings/ratingId")
	public Rating deleteRating(@PathVariable Integer ratingId);
	
}
