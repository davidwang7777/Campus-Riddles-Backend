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




@Entity
@Table(name = "hunters")
public class Hunter  {
	/*
	 * Use to have @Data, @NoArgsConstructor, @AllArgsContrustor, @Email, @NotBlank
	 */
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	
	private Instant created;
	private boolean enabled;
	
	/*
	 * CONSTRUCTORS
	 */
	public Hunter () {}
	public Hunter (Hunter temp) {
		this.enabled = temp.isEnabled();
		this.email = temp.getEmail();
		this.username = temp.getUsername();
		this.password = temp.getPassword();
		this.id = temp.getId();
	}
	
	
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Instant getCreated() {
		return created;
	}
	public void setCreated(Instant created) {
		this.created = created;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
