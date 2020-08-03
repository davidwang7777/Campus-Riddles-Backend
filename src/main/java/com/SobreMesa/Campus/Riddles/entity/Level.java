package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "levels")
public class Level {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//maybe wrong? -> database name is: level_number
	private int levelnumber;
	private int riddle;
	public Level() {}
	public Level(int levelnumber, int riddle) {
		super();
		this.levelnumber = levelnumber;
		this.riddle = riddle;
	}
	
	public int getLevelnumber() {
		return levelnumber;
	}
	public void setLevelnumber(int levelnumber) {
		this.levelnumber = levelnumber;
	}
	public int getRiddle() {
		return riddle;
	}
	public void setRiddle(int riddle) {
		this.riddle = riddle;
	}
}
