package com.HotelService.HotelService.exception;

// Creating A Exception Class, When Resource Not Found

@SuppressWarnings("all")
public class ResourceNotFoundException extends RuntimeException 
{
	public ResourceNotFoundException() {
		super("Resource Not Found On Server");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
