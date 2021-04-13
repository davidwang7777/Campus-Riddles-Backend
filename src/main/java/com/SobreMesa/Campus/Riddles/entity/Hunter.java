package com.SobreMesa.Campus.Riddles.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;




@Entity
@Getter
@Setter
@Table(name = "hunters")
public class Hunter  {
	/*
	 * Use to have @Data, @NoArgsConstructor, @AllArgsContrustor, @Email, @NotBlank
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name="hunter_id", referencedColumnName = "id")
	private List<CommunityForum> communityForums = new ArrayList<>();
	@ManyToMany
	@JoinTable(
			  name = "hunters_riddles", 
			  joinColumns = @JoinColumn(name = "hunter_riddle_id"), 
			  inverseJoinColumns = @JoinColumn(name = "riddle_hunter_id"))
    private List<Riddle> subscribedRiddles;
	
	public Hunter(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	private Instant created;
	private boolean enabled;
	
	/*
	 * CONSTRUCTORS
	 */
	public Hunter () {}
	public Hunter (Hunter temp) {
		this.enabled = temp.isEnabled();
		this.email = temp.getEmail();
		this.username = temp.getUsername();
		this.password = temp.getPassword();
		this.id = temp.getId();
	}
	

}
