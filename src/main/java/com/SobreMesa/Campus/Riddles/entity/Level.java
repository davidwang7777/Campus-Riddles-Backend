package com.SobreMesa.Campus.Riddles.entity;

import javax.persistence.Column;
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
	private int level_number;

	private String question;
	private String answer;
	@Column(insertable = false, nullable = true)
	private int fk_riddles_levels;
	
	public Level() {}
	public Level(int level_number, String question, String answer) {
		super();
		this.level_number = level_number;
		this.question = question;
		this.answer = answer;
	}
	public int getLevelnumber() {
		return level_number;
	}
	public void setLevelnumber(int levelnumber) {
		this.level_number = levelnumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getFk_riddles_levels() {
		return fk_riddles_levels;
	}
	public void setFk_riddles_levels(int fk_riddles_levels) {
		this.fk_riddles_levels = fk_riddles_levels;
	}
	
}
