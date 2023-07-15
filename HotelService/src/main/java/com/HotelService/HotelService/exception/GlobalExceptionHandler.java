package com.HotelService.HotelService.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Creating A Class For Any Type Of Exception

@RestControllerAdvice
@SuppressWarnings("all")
public class GlobalExceptionHandler {
	
	public ResponseEntity<Map<Integer, Object>> notFoundHandler(ResourceNotFoundException ex)
	{
		Map map = new HashMap();
		map.put("mesage",ex.getMessage());
		map.put("success", false);
		map.put("status", HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
