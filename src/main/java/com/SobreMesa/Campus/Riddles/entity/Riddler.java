package com.SobreMesa.Campus.Riddles.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="riddlers")
public class Riddler {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private String last_name;
	private String username;
	private String email;
	private String password;
	private String school;
	private String campus_location;
	private String id_image;
	private String isearch_link;
	private String profile_picture;
	private int hunter_account;
	
//	@OneToMany(targetEntity = Riddle.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="riddler_fk", referencedColumnName= "id")
//	private  List<Riddle> riddles;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "riddler_id", referencedColumnName= "id")
	private List<Riddle> riddles = new ArrayList<>();
	
	
	public Riddler() {}
	public Riddler(String first_name, String last_name, String username, String email, String password, String school,
			String campus_location, String id_image, String isearch_link, String profile_picture, int hunter_account) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.school = school;
		this.campus_location = campus_location;
		this.id_image = id_image;
		this.isearch_link = isearch_link;
		this.profile_picture = profile_picture;
		this.hunter_account = hunter_account;
	}

	public String getfirst_name() {
		return first_name;
	}

	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getlast_name() {
		return last_name;
	}

	public void setlast_name(String last_name) {
		this.last_name = last_name;
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getcampus_location() {
		return campus_location;
	}

	public void setcampus_location(String campus_location) {
		this.campus_location = campus_location;
	}

	public String getId_image() {
		return id_image;
	}

	public void setId_image(String id_image) {
		this.id_image = id_image;
	}

	public String getisearch_link() {
		return isearch_link;
	}

	public void setisearch_link(String isearch_link) {
		this.isearch_link = isearch_link;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

	public int gethunter_account() {
		return hunter_account;
	}

	public void sethunter_account(int hunter_account) {
		this.hunter_account = hunter_account;
	}
	public List<Riddle> getRiddles() {
		return riddles;
	}
	public void setRiddles(List<Riddle> riddles) {
		this.riddles = riddles;
	}
	
}
