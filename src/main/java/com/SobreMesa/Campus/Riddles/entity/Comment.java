package com.SobreMesa.Campus.Riddles.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private String hunter_username;
	private int forum_id;
	private Instant created;
	
	
	public Comment() {}
	
	public Comment(String text, String hunter_username) {
		super();
		this.text = text;
		this.hunter_username = hunter_username;
	}

	
	
	
	
	
}
