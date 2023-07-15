package com.HotelService.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelService.HotelService.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> 
{

}
