package com.user.service.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.service.UserService.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{

}
