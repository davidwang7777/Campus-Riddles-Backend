package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "allriddles")
public class Riddle {
	
	/*
	 * ATTRIBUTES
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private int difficulty;
	private String prize;
	private String riddlerName;
	private int levels;
	private String riddleDescription;
	
	/*
	 * CONSTRUCTORS
	 */
	public Riddle() {}
	public Riddle( String title, int difficulty, String prize, String riddlerName, int levels,
			String description) {
		super();
		
		this.title = title;
		this.difficulty = difficulty;
		this.prize = prize;
		this.riddlerName = riddlerName;
		this.levels = levels;
		this.riddleDescription = description;
	}

	
	
	/*
	 * GETTERS AND SETTERS
	 */
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


	public int getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}


	public String getPrize() {
		return prize;
	}


	public void setPrize(String prize) {
		this.prize = prize;
	}


	public String getRiddlerName() {
		return riddlerName;
	}


	public void setRiddlerName(String riddlerName) {
		this.riddlerName = riddlerName;
	}


	public int getLevels() {
		return levels;
	}


	public void setLevels(int levels) {
		this.levels = levels;
	}


	public String getDescription() {
		return riddleDescription;
	}


	public void setDescription(String description) {
		this.riddleDescription = description;
	}
	
	/*
	 * OPERATIONS
	 */
	
}
