package com.SobreMesa.Campus.Riddles.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SobreMesa.Campus.Riddles.entity.Comment;
import com.SobreMesa.Campus.Riddles.entity.CommunityForum;

import Enum.ResponseStatus;

public class CommentResponse {
	@Autowired 
	private ResponseStatus response;
	
	private String message;
	
	@Autowired 
	private List<Comment> comments;

	public CommentResponse(ResponseStatus response, String message, List<Comment> comments) {
		super();
		this.response = response;
		this.message = message;
		this.comments = comments;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setCommunityForums(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
