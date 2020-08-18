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
@Table(name = "community_forum")
public class CommunityForum {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private String media;
	private String hunter_username;
	private int hunter_id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="forum_id", referencedColumnName ="id")
	private List<Comment> comments = new ArrayList<>();
	
	
	public CommunityForum() {}
	public CommunityForum(String title, String content, String media, String hunter_username) {
		super();
		this.title = title;
		this.content = content;
		this.media = media;
		this.hunter_username = hunter_username;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getHunter_username() {
		return hunter_username;
	}
	public void setHunter_username(String hunter_username) {
		this.hunter_username = hunter_username;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public int getHunter_id() {
		return hunter_id;
	}
	public void setHunter_id(int hunter_id) {
		this.hunter_id = hunter_id;
	}

	
}
