package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * @ManyToOne annotation says there are many experiences to one Riddle. 
 * this is a JPA specific annotation coming from package javax.persistence and has nothing
 * to do with spring boot or spring jpa. its basically its own framework and hibernate knows
 * exactly what to do when it reads the annotation. This gives you the ability to do ORM. 
 */

@Entity
public class Experience {
	
	/*
	 * ATTRIBUTES
	 */
	@Id
	private int id;
	private String name;
	private String description;
	private String experience_type;
	
	@ManyToOne
	private Riddle riddle;
	
	
	/*
	 * CONSTRUCTORS
	 */
	public Experience(String name, String description, String experience_type) {
		super();
		this.name = name;
		this.description = description;
		this.experience_type = experience_type;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getExperience_type() {
		return experience_type;
	}


	public void setExperience_type(String experience_type) {
		this.experience_type = experience_type;
	}
	
	/*
	 * OPERATIONS
	 */
	
	
	
}
