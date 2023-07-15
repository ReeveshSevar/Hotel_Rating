package com.user.service.UserService.exception;


// Creating An Exception Class When Resource Not Found

@SuppressWarnings("all")
public class ResourceNotFound extends RuntimeException 
{	
	public ResourceNotFound() {
		super("Resource Not Found On Server");
	}
	
	public ResourceNotFound(String message) {
		super(message);
	}
	
}
