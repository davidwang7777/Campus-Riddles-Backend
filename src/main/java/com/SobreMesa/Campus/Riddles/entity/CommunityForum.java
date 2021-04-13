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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	public CommunityForum(String title, String content, String media, String hunter_username) {
		super();
		this.title = title;
		this.content = content;
		this.media = media;
		this.hunter_username = hunter_username;
	}
}
