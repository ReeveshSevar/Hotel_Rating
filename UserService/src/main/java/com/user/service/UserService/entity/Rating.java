package com.user.service.UserService.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;
}
