package com.SobreMesa.Campus.Riddles.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.CommunityForum;
import com.SobreMesa.Campus.Riddles.entity.Riddle;
import com.SobreMesa.Campus.Riddles.repo.CommunityForumRepository;
@Service
public class CommunityForumService {
	
	@Autowired
	CommunityForumRepository communityForumRepository;

	public void addCommunityForum(CommunityForum communityForum) {
		communityForumRepository.save(communityForum);
	}
	
	public List<CommunityForum> getCommunityForums(){
		List<CommunityForum> communityForums = new ArrayList<>();
		communityForumRepository.findAll()
		.forEach(communityForums::add);
		
	
		return communityForums;
	}
	
}
