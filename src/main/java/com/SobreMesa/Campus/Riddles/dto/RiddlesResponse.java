package com.SobreMesa.Campus.Riddles.dto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SobreMesa.Campus.Riddles.entity.*;

import Enum.ResponseStatus;

public class RiddlesResponse {
	@Autowired
	private ResponseStatus response;
	
	private String message;
	
	@Autowired
	private List<Riddle> riddles;
	
	public RiddlesResponse(ResponseStatus response, String message, List<Riddle> riddles) {
		super();
		this.response = response;
		this.message = message;
		this.riddles = riddles;
		
		
	}

	public ResponseStatus getResponse() {
		return response;
	}

	public void setResponse(ResponseStatus response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Riddle> getRiddles() {
		return riddles;
	}

	public void setRiddles(List<Riddle> riddles) {
		this.riddles = riddles;
	}
	
	
}
