package com.SobreMesa.Campus.Riddles.Services;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public List<CommunityForum> getAllCommunityForums(){
		List<CommunityForum> communityForums = new ArrayList<>();
		communityForumRepository.findAll()
		.forEach(communityForums::add);
		return communityForums;
	}
	
//	public List<CommunityForum> getCommunityForumByTitle(String title){
//		List<CommunityForum> communityForums = new ArrayList<>();
//		communityForumRepository.findByTitle(title)
//		.forEach(communityForums::add);
//		return communityForums;
//	}
	public List<CommunityForum> getCommunityForumByKeyword(String keyword){
	List<CommunityForum> communityForums = new ArrayList<>();
	communityForumRepository.findAll()
	.forEach(communityForums::add);
	
	
	for (CommunityForum cf : communityForums) {
		//if forum does not contain keyword, remove it from list.
		if (cf.getTitle().contains(keyword)) {
			
			System.out.println(cf.getTitle());
			//communityForums.remove(cf);
		}else {
			communityForums.remove(cf);
		}
	}
	
	
	for (Iterator<CommunityForum> iterator = communityForums.iterator(); iterator.hasNext();) {
		CommunityForum cf = iterator.next();
		    if (cf.getTitle().contains(keyword) ) {
		      
		    }else {
		    	 // Remove the current element from the iterator and the list.
			       iterator.remove();
		    }
	
	}
	return communityForums;
		
	}
	
}
