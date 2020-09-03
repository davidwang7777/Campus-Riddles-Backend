package com.SobreMesa.Campus.Riddles.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.CommunityForum;
import com.SobreMesa.Campus.Riddles.entity.Hunter;
import com.SobreMesa.Campus.Riddles.entity.Riddle;
import com.SobreMesa.Campus.Riddles.repo.CommunityForumRepository;
import com.SobreMesa.Campus.Riddles.repo.HunterRepository;
@Service
public class CommunityForumService {
	
	@Autowired
	CommunityForumRepository communityForumRepository;
	
	@Autowired 
	HunterRepository hunterRepository;

	public String addCommunityForum(CommunityForum communityForum) {
		
		
		Optional<Hunter> hunterOptional = hunterRepository.findById(communityForum.getHunter_id());
		
		
		if (hunterOptional.isPresent())
		{
		    //doSomethingWithUser(user.get());
			Hunter hunter = hunterOptional.get();
			try {
				communityForum.setHunter_username(hunter.getUsername());
				communityForum.setCreated(java.time.Instant.now());
				hunter.getCommunityForums().add(communityForum);
				//System.out.println("IN FORUMS SERVICE - right before save call");
				hunterRepository.save(hunter);
				
				
			}catch (DataIntegrityViolationException e){
				return "Forum with that name already exists, chose different name,";
			}
			
			return "success";
			
		}else {
		
			return "No hunter found for that id.";
		}
	}
	
	public List<CommunityForum> findForumsByOldest(){
		List<CommunityForum> communityForums = new ArrayList<>();
		communityForumRepository.findAll()
		.forEach(communityForums::add);
		return communityForums;
	}
	public List<CommunityForum> findForumsByNewest(){
		List<CommunityForum> communityForums = new ArrayList<>();
		communityForumRepository.findForumsByNewest()
		.forEach(communityForums::add);
		return communityForums;
	}
	public List<CommunityForum> findForumsByAscVotecount(){
		List<CommunityForum> communityForums = new ArrayList<>();
		communityForumRepository.findForumsByAscVotecount()
		.forEach(communityForums::add);
		return communityForums;
	}
	
	public List<CommunityForum> findForumsByDscVotecount(){
		List<CommunityForum> communityForums = new ArrayList<>();
		communityForumRepository.findForumsByDscVotecount()
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
	
//	public void createdToTimeAgo(List<Riddle> riddles) {
//		riddles.forEach(riddle -> 
//		riddle.setCreatedstring(
//				MilliToTimeAgo(riddle.getCreated().toEpochMilli())
//				)
//		);
//	}
//	
//	public String MilliToTimeAgo(long createdTime) {
//		long timePassedInMilli =  System.currentTimeMillis() - createdTime;
//		
//		System.out.println(timePassedInMilli);
//		
//		List<Long> times = Arrays.asList(
//		        TimeUnit.DAYS.toMillis(365),
//		        TimeUnit.DAYS.toMillis(30),
//		        TimeUnit.DAYS.toMillis(1),
//		        TimeUnit.HOURS.toMillis(1),
//		        TimeUnit.MINUTES.toMillis(1),
//		        TimeUnit.SECONDS.toMillis(1) );
//		List<String> timesString = Arrays.asList("year","month","day","hour","minute","second");
//		
//		   StringBuffer res = new StringBuffer();
//		   
//		    for(int i=0;i< times.size(); i++) {
//		        Long current = times.get(i);
//		        long temp = timePassedInMilli/current;
//		        if(temp>0) {
//		        	
//		            res.append(temp).append(" ").append( timesString.get(i) ).append(temp != 1 ? "s" : "").append(" ago");
//		            break;
//		        }
//		    }
//		    if("".equals(res.toString()))
//		        return "0 seconds ago";
//		    else
//		        return res.toString();
//	}

}
