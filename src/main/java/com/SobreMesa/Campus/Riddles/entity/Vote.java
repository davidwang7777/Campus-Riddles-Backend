package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Column;
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
}
