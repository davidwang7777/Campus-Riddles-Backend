package com.SobreMesa.Campus.Riddles.Services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.CommunityForum;
import com.SobreMesa.Campus.Riddles.entity.Hunter;
import com.SobreMesa.Campus.Riddles.entity.Vote;
import com.SobreMesa.Campus.Riddles.repo.CommunityForumRepository;
import com.SobreMesa.Campus.Riddles.repo.HunterRepository;

@Service
public class VoteService {
	@Autowired
	CommunityForumRepository communityForumRepository;
	@Autowired
	HunterRepository hunterRepository;

	public String addVote(Vote vote) {
		
		
		
		
		System.out.println("Got to save vote SERVICE" + "fk:" +vote.getfk_vote_forum());
		Optional<CommunityForum> forumOptional = communityForumRepository.findById(vote.getfk_vote_forum());
		//communityForumRepository.findById(vote.getFK_vote_forum());
		
		
		System.out.println("got/found FORUM");
		
		//System.out.println(forumOptional.get());
		
		if (forumOptional.isPresent() )
		{
			System.out.println("Got to save vote EXISTS");
			CommunityForum forum = forumOptional.get();
			System.out.println("Forum id:" +forum.getId());
			Optional<Hunter> hunterOptional = hunterRepository.findById(forum.getHunter_id());
			
			
			
			if (hunterOptional.isPresent() )
			{
				System.out.println("Got to save hunter EXISTS");
				Hunter hunter = hunterOptional.get();
				try {
					
					vote.setHunter_username(hunter.getUsername());
					forum.getVotes().add(vote);
					int newVoteCount = forum.getVotecount() + vote.getVote();
					forum.setVotecount(newVoteCount);
					communityForumRepository.save(forum);
					System.out.println("Got to save comm forum  vote SAVE");
//					
				}catch (NoSuchElementException e){
					return e.getMessage();
				}
				
				return "suceess";
				
			}else {
				
				return "No hunter found for that id.";
			}
		
			
		}else {
		
			return "No forum found for that id.";
		}
	}
	
}
