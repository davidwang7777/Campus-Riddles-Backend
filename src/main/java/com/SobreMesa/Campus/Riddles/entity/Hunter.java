package com.SobreMesa.Campus.Riddles.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "hunters")
public class Hunter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name="hunter_id", referencedColumnName = "id")
	private List<CommunityForum> communityForums = new ArrayList<>();
	
	public Hunter() {}
	public Hunter(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
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
	public List<CommunityForum> getCommunityForums() {
		return communityForums;
	}
	public void setCommunityForums(List<CommunityForum> communityForums) {
		this.communityForums = communityForums;
	}
	
}
