package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private String hunter_username;
	private int forum_id;
	
	
	public Comment() {}
	
	public Comment(String text, String hunter_username) {
		super();
		this.text = text;
		this.hunter_username = hunter_username;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHunter_username() {
		return hunter_username;
	}
	public void setHunter_username(String hunter_username) {
		this.hunter_username = hunter_username;
	}

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	
	
	
	
	
}
