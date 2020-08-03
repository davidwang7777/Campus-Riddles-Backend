package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * @ManyToOne annotation says there are many experiences to one Riddle. 
 * this is a JPA specific annotation coming from package javax.persistence and has nothing
 * to do with spring boot or spring jpa. its basically its own framework and hibernate knows
 * exactly what to do when it reads the annotation. This gives you the ability to do ORM. 
 */

@Entity
@Table(name = "experiences")
public class Experience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int type;
	private int level;
	
	public Experience() {}
	public Experience(int type, int level) {
		this.type = type;
		this.level = level;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
