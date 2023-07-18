package com.HotelService.HotelService.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hotels")
public class Hotel {
	@Id
	private Integer hotelID;
	private String name;
	private String location;
	private String about;
	@Transient
	private List<Rating> ratings = new ArrayList<>(); 
}
