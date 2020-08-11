package com.SobreMesa.Campus.Riddles.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Enum.ResponseStatus;
import com.SobreMesa.Campus.Riddles.entity.*;

public class CommunityForumResponse {

	@Autowired 
	private ResponseStatus response;
	
	private String message;
	
	@Autowired 
	private List<CommunityForum> communityForums;

	public CommunityForumResponse(ResponseStatus response, String message, List<CommunityForum> communityForums) {
		super();
		this.response = response;
		this.message = message;
		this.communityForums = communityForums;
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

	public List<CommunityForum> getCommunityForums() {
		return communityForums;
	}

	public void setCommunityForums(List<CommunityForum> communityForums) {
		this.communityForums = communityForums;
	}
	
	
	
	
}
