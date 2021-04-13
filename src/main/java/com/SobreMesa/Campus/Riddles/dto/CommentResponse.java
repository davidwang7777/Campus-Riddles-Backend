package com.SobreMesa.Campus.Riddles.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SobreMesa.Campus.Riddles.entity.Comment;
import com.SobreMesa.Campus.Riddles.entity.CommunityForum;

import lombok.Getter;
import lombok.Setter;

import Enum.ResponseStatus;
@Getter
@Setter
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
}
