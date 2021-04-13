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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
