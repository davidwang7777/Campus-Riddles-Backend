package com.SobreMesa.Campus.Riddles.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.CommunityForum;
import com.SobreMesa.Campus.Riddles.repo.CommunityForumRepository;
@Service
public class CommunityForumService {
	
	@Autowired
	CommunityForumRepository communityForumRepository;

	public String addCommunityForum(CommunityForum communityForum) {
		try{
			communityForumRepository.save(communityForum);
		}
		catch(DataAccessException e){
			return e.getMessage();
		}
		
		return "success";
	}
	
	public List<CommunityForum> getAllCommunityForums(){
		List<CommunityForum> communityForums = new ArrayList<>();
		communityForumRepository.findAll()
		.forEach(communityForums::add);
		return communityForums;
	}
	
	
	public  List<CommunityForum> getCommunityForum(int communityForumId) {
		List<CommunityForum> communityForums = new ArrayList<>();
		Optional<CommunityForum> c =  communityForumRepository.findById(communityForumId);
		
		//returns found forum or null
		 communityForums.add( c.orElse(null));
		 return communityForums;
	}
	
	public String updateCommunityForum(CommunityForum communityForum){
		/*
		 * This method updates an existing riddle, BUT DOESNT CHECK IF ITS EXISTS. 
		 * Since the riddle object already has the id, spring boot should know that 
		 * it already exists in the database so it will just update all the fields 
		 * of that object
		 * 
		 * Args:
		 * 		an existing riddle object
		 * 
		 * Returns:
		 * 		None
		 */

		
		try {
			communityForumRepository.save(communityForum);
			
		}
		catch(NoSuchElementException e){
			return e.getMessage();
		}
		
		return "success";

	}
	
	
	public String deleteCommunityForum(int communityForumId) {
		
		try{
			communityForumRepository.deleteById(communityForumId);
		}
		catch(DataAccessException e){
			return e.getMessage();
		}
		
		return "success";
		
	}
	
	
	
//	public List<CommunityForum> getCommunityForumByTitle(String title){
//		List<CommunityForum> communityForums = new ArrayList<>();
//		communityForumRepository.findByTitle(title)
//		.forEach(communityForums::add);
//		return communityForums;
//	}
	public List<CommunityForum> getCommunityForumByKeyword(String keyword) {
		List<CommunityForum> communityForums = new ArrayList<>();
		communityForumRepository.findAll().forEach(communityForums::add);

		for (CommunityForum cf : communityForums) {
			// if forum does not contain keyword, remove it from list.
			if (cf.getTitle().contains(keyword)) {

				System.out.println(cf.getTitle());
				// communityForums.remove(cf);
			} else {
				communityForums.remove(cf);
			}
		}

		for (Iterator<CommunityForum> iterator = communityForums.iterator(); iterator.hasNext();) {
			CommunityForum cf = iterator.next();
			if (cf.getTitle().contains(keyword)) {

			} else {
				// Remove the current element from the iterator and the list.
				iterator.remove();
			}

		}
		return communityForums;

	}

}
