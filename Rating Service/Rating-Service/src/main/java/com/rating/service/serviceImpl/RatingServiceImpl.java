package com.rating.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rating.service.entity.Rating;
import com.rating.service.repository.RatingRepository;
import com.rating.service.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService 
{
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(Integer id) {
		return ratingRepository.findByUserId(id);
	}

	@Override
	public List<Rating> getRatingByHotelId(Integer id) {
		return ratingRepository.findByHotelId(id);
	}

}
