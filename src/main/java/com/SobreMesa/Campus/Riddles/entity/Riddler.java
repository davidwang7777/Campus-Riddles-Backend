package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="riddlers")
public class Riddler implements CRUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String password;
	private String school;
	private String campuslocation;
	private String id_image;
	private String isearcklink;
	private String profile_picture;
	private int hunteraccount;
	public Riddler() {}
	public Riddler(String firstname, String lastname, String username, String email, String password, String school,
			String campuslocation, String id_image, String isearcklink, String profile_picture, int hunteraccount) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.school = school;
		this.campuslocation = campuslocation;
		this.id_image = id_image;
		this.isearcklink = isearcklink;
		this.profile_picture = profile_picture;
		this.hunteraccount = hunteraccount;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getCampuslocation() {
		return campuslocation;
	}

	public void setCampuslocation(String campuslocation) {
		this.campuslocation = campuslocation;
	}

	public String getId_image() {
		return id_image;
	}

	public void setId_image(String id_image) {
		this.id_image = id_image;
	}

	public String getIsearcklink() {
		return isearcklink;
	}

	public void setIsearcklink(String isearcklink) {
		this.isearcklink = isearcklink;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

	public int getHunteraccount() {
		return hunteraccount;
	}

	public void setHunteraccount(int hunteraccount) {
		this.hunteraccount = hunteraccount;
	}
	
}
