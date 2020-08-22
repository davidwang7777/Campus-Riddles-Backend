package com.SobreMesa.Campus.Riddles.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

	//@JoinColumn( name = "riddle_id", referencedColumnName= "id")
	//to map many riddle_ids to a single hunter object
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name="riddles")
//	private List<Riddle> subscribed_riddles = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			  name = "hunters_riddles", 
			  joinColumns = @JoinColumn(name = "hunter_riddle_id"), 
			  inverseJoinColumns = @JoinColumn(name = "riddle_hunter_id"))
    private List<Riddle> subscribedRiddles;
	
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
//	public List<Riddle> getSubscribed_riddles() {
//		return subscribed_riddles;
//	}
//	public void setSubscribed_riddles(List<Riddle> subscribed_riddles) {
//		this.subscribed_riddles = subscribed_riddles;
//	}
//	
	public List<Riddle> getSubscribedRiddles() {
		return subscribedRiddles;
	}
	public void setSubscribedRiddles(List<Riddle> subscribedRiddles) {
		this.subscribedRiddles = subscribedRiddles;
	}
}
