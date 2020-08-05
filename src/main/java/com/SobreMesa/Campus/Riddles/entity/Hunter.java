package com.SobreMesa.Campus.Riddles.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hunters")
public class Hunter implements CRUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "username is required")
	private String username;
	
	@Email
	@NotEmpty(message = "Email is Required")
	private String email;
	
	@NotBlank(message = "password is required")
	private String password;
	
	private Instant created;
	private boolean enabled;
}
