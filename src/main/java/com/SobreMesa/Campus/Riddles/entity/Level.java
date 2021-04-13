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
@Table(name= "levels")
public class Level {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
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
}
