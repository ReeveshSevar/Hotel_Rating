package com.HotelService.HotelService.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.HotelService.HotelService.entity.Hotel;
import com.HotelService.HotelService.entity.Rating;
import com.HotelService.HotelService.exception.ResourceNotFoundException;
import com.HotelService.HotelService.repository.HotelRepository;
import com.HotelService.HotelService.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService 
{
	
	@Autowired
	private HotelRepository hotelRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	
//  For Creating Hotel
	@Override
	public Hotel create(Hotel hotel) {
		Integer id = UUID.randomUUID().hashCode();
		hotel.setHotelID(id);
		return hotelRepository.save(hotel);
	}

//  For Fetching All Hotels
	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

//  For Fetching Single Hotel
	@Override
	public Hotel get(Integer id) {
		Optional<Hotel> opt = hotelRepository.findById(id);
		if(opt.isPresent())
		{
			Hotel hotel = opt.get();
			
			// Fetching Ratings Of Hotels 
			Rating[] ratingOfHotel = restTemplate.getForObject("http://localhost:1113/ratings/hotels/"+hotel.getHotelID(),Rating[].class);
			
			List<Rating> ratings = Arrays.stream(ratingOfHotel).toList();
			
			hotel.setRatings(ratings);
			
			return hotel;
		}
		else
			throw new ResourceNotFoundException("Hotel With Given Id Is Not Found On Server !! "+id);
	}
	
}
