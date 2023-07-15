package com.user.service.UserService.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="micro_users")
@Builder
public class User {
	@Id
	@Column(name="ID")
	private Integer userId;
	
	@Column(name="NAME", length = 20)
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ABOUT")
	private String about;
	
	
	@Transient  // Used To Neglect
	private List<Rating> ratings = new ArrayList<>();
}
