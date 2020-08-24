package com.SobreMesa.Campus.Riddles.entity;

import java.time.Instant;
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
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_vote_forum", referencedColumnName ="id")
	private List<Vote> votes = new ArrayList<>();
	private int votecount;
	private Instant created;
	
	public CommunityForum(int id, String title, String content, String media, int votecount) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.media = media;
		this.votecount = votecount;
	}
	public CommunityForum() {}
//	public CommunityForum(String title, String content, String media, String hunter_username) {
//		super();
//		this.title = title;
//		this.content = content;
//		this.media = media;
//		this.hunter_username = hunter_username;
//	}
	
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
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	public int getVotecount() {
		return votecount;
	}
	public void setVotecount(int votecount) {
		this.votecount = votecount;
	}
	public Instant getCreated() {
		return created;
	}
	public void setCreated(Instant created) {
		this.created = created;
	}
	

	
}
