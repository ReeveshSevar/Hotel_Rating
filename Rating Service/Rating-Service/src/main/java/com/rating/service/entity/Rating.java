package com.rating.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Rating")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private int rating;
	private String feedback;
}
