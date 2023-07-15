package com.user.service.UserService.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.user.service.UserService.entity.Hotel;
import com.user.service.UserService.entity.Rating;
import com.user.service.UserService.entity.User;
import com.user.service.UserService.exception.ResourceNotFound;
import com.user.service.UserService.repository.UserRepository;
import com.user.service.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private RestTemplate restTemplate;
		
//  For Create User
	@Override
	public User saveUser(User user) {
		Integer randomUserId = UUID.randomUUID().hashCode();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

//  For Fetching All User
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

//  For Fetching Single User
	@Override
	public User getUser(Integer id) {
		Optional<User> opt = userRepository.findById(id);
		if(opt.isPresent())
		{
			User user = opt.get();
			
			// Getting Rating Which Is Given By User To hotels
			Rating[] ratingOfUser= restTemplate.getForObject("http://localhost:1113/ratings/users/"+user.getUserId(),Rating[].class);
			
			List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
			
			List<Rating> ratingList = ratings.stream().map(rating ->{
				
				// Getting Rating Of Hotels
				ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:1112/hotels/"+rating.getHotelId(), Hotel.class);
				
				Hotel hotel = forEntity.getBody();
				
				rating.setHotel(hotel);
				
				return rating;
				
			}).collect(Collectors.toList());
			
			user.setRatings(ratingList);
			return user;
		}
		else
			throw new ResourceNotFound("User With Given Id Is Not Found On Server !! "+id);
	}
}
