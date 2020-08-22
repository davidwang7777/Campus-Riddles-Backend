package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="votes")
public class Vote {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int vote;
	private String hunter_username;
	private int fk_vote_forum;
	
	public Vote() {}
	
	public Vote(int vote, String hunter_username) {
		super();
		this.vote = vote;
		this.hunter_username = hunter_username;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public String getHunter_username() {
		return hunter_username;
	}
	public void setHunter_username(String hunter_username) {
		this.hunter_username = hunter_username;
	}
	public int getfk_vote_forum() {
		return fk_vote_forum;
	}
	public void setfk_vote_forum(int fK_vote_forum) {
		fk_vote_forum = fK_vote_forum;
	}
	
}
