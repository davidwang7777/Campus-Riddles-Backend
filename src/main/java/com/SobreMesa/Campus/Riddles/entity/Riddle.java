package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "riddles")
public class Riddle {
	
	/*
	 * ATTRIBUTES
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private int difficulty;
	private String prize;
	private String riddlername;
	private String riddledescription;
	private String location;
	private int riddler_id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "fk_riddles_levels", referencedColumnName= "id")
	private List<Level> levels = new ArrayList<>();
	private boolean completed;
	private Instant created;
	
	
	
	
	
	public Riddle(int id, String title, int difficulty, String prize, String riddlername, int levels,
			String riddledescription, String location, int riddler_id) {
		super();
		this.id = id;
		this.title = title;
		this.difficulty = difficulty;
		this.prize = prize;
		this.riddlername = riddlername;
		this.riddledescription = riddledescription;
		this.location = location;
		this.riddler_id = riddler_id;
	}
//	@ManyToOne
//	@JoinColumn(name="riddlerId")
//	private Riddler riddler;
	/*
	 * CONSTRUCTORS
	 */
	public Riddle() {}
	public Riddle( String title, int difficulty, String prize, String riddlername, int levels,
			String riddledescription, String location) {
		super();
		
		this.title = title;
		this.difficulty = difficulty;
		this.prize = prize;
		this.riddlername = riddlername;
		this.riddledescription = riddledescription;
		//this.riddler = riddler;
		this.location = location;
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
	public String getRiddlername() {
		return riddlername;
	}
	public void setRiddlername(String riddlername) {
		this.riddlername = riddlername;
	}
//	public int getLevels() {
//		return levels;
//	}
//	public void setLevels(int levels) {
//		this.levels = levels;
//	}
	public String getRiddledescription() {
		return riddledescription;
	}
	public void setRiddledescription(String riddledescription) {
		this.riddledescription = riddledescription;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
//	public Riddler getRiddler() {
//		return riddler;
//	}
//	public void setRiddler(Riddler riddler) {
//		this.riddler = riddler;
//	}

	
	public void printAllFields() {
		System.out.println("The riddle object looks like:");
		System.out.println("id:" + this.id);
		System.out.println("title:" + this.title);
		System.out.println("difficulty:" + this.difficulty);
		System.out.println("prize:" + this.prize);
		System.out.println("riddlername:" + this.riddlername);
		System.out.println("levels:" + this.levels);
		System.out.println("riddle description:" + this.riddledescription);
		System.out.println("location:" + this.location);
		//System.out.println("riddler username:" + this.riddler.getUsername());
	}
	/*
	
	/*
	 * GETTERS AND SETTERS
	 */
	public int getRiddler_id() {
		return riddler_id;
	}
	public void setRiddler_id(int riddler_id) {
		this.riddler_id = riddler_id;
	}
	public List<Level> getLevels() {
		return levels;
	}
	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Instant getCreated() {
		return created;
	}
	public void setCreated(Instant created) {
		this.created = created;
	}
	
	
	/*
	 * OPERATIONS
	 */
	
}
