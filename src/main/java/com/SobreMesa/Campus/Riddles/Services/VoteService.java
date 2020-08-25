package com.SobreMesa.Campus.Riddles.Services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.CommunityForum;
import com.SobreMesa.Campus.Riddles.entity.Hunter;
import com.SobreMesa.Campus.Riddles.entity.Vote;
import com.SobreMesa.Campus.Riddles.repo.CommunityForumRepository;
import com.SobreMesa.Campus.Riddles.repo.HunterRepository;
import com.SobreMesa.Campus.Riddles.repo.VoteRepository;

@Service
public class VoteService {
	@Autowired
	CommunityForumRepository communityForumRepository;
	@Autowired
	HunterRepository hunterRepository;
	@Autowired
	VoteRepository voteRepository;

	public String addVote(Vote vote) {
		
		
		if (vote.getVote() == 1) {
			System.out.println("****UPVOTE +1");
		}
		else if (vote.getVote() == -1) {
			System.out.println("****DOWNVOTE -1");
		}
		
		
		
		Optional<Vote> voteOptional = voteRepository.findByUsernameAndForumId(
				vote.getHunter_username(), vote.getfk_vote_forum());
		if (voteOptional.isPresent()) {
			Vote myPreviousVote = voteOptional.get();
			System.out.println("FOUND PRIOR vote");
			
			
			myPreviousVote.setVote(vote.getVote());
			
		
			
			//update previous vote
			voteRepository.save(myPreviousVote);
			
			//System.out.println(myvote.getVote());
			
		}else {
			
			
			voteRepository.save(vote);
			
			
			
		}
		
		List<Integer> voteValues = voteRepository.findVotesValuesByForumId(vote.getfk_vote_forum());
		
		for(int i = 0; i< voteValues.size(); i++) {
			System.out.println(voteValues.get(i));
		}
		
		
		Integer sum = voteValues.stream()
				  .reduce(0, Integer::sum);
		
		
		System.out.println("myVoteSum==>"+sum);
		
		updateForumVoteCount(sum ,vote.getfk_vote_forum());
		
		//updateForumVoteCount(vote.getVote(),vote.getfk_vote_forum());
		
		return "";
		
		
//		
//		
//		//System.out.println("Got to save vote SERVICE" + "fk:" +vote.getfk_vote_forum());
//		Optional<CommunityForum> forumOptional = communityForumRepository.findById(vote.getfk_vote_forum());
//		//communityForumRepository.findById(vote.getFK_vote_forum());
//		
//		
//		System.out.println("got/found FORUM");
//		
//		//System.out.println(forumOptional.get());
//		
//		if (forumOptional.isPresent() )
//		{
//			System.out.println("Got to save vote EXISTS");
//			CommunityForum forum = forumOptional.get();
//			System.out.println("Forum id:" +forum.getId());
//			Optional<Hunter> hunterOptional = hunterRepository.findById(forum.getHunter_id());
//			
//			
//			
//			if (hunterOptional.isPresent() )
//			{
//				System.out.println("Got to save hunter EXISTS");
//				Hunter hunter = hunterOptional.get();
//				try {
//					
//					vote.setHunter_username(hunter.getUsername());
//					
//					//check if previous vote exists
//					
//					
////					
////					if (!hunterIsPreviousVoter(forum, hunter.getUsername() )) {
////						
////					}
////					
////					
////					isHunterPreviousVote
//					
//					
//					forum.getVotes().add(vote);
//					int newVoteCount = forum.getVotecount() + vote.getVote();
//					forum.setVotecount(newVoteCount);
//					communityForumRepository.save(forum);
//					System.out.println("Got to save comm forum  vote SAVE");
////					
//				}catch (NoSuchElementException e){
//					return e.getMessage();
//				}
//				
//				return "suceess";
//				
//			}else {
//				
//				return "No hunter found for that id.";
//			}
//		
//			
//		}else {
//		
//			return "No forum found for that id.";
//		}
	}

	private void updateForumVoteCount(int newVoteCount, int forum_id) {
		CommunityForum forum = communityForumRepository.findById( forum_id).get();
		forum.setVotecount(newVoteCount);
		communityForumRepository.save(forum);
	}

//	private boolean hunterIsPreviousVoter(CommunityForum forum) {
//		// TODO Auto-generated method stub
//		for (int x = 0; x< forum.getVotes().size(); x++) {
//			if (forum.getVotes().get(x).getHunter_username() == hunter.getUsername()) {
//				System.out.println("Found the user vote again");
//				Vote updated = forum.getVotes().get(x);
//				updated.setVote(vote.getVote());
//				int newVoteCount = forum.getVotecount() + updated.getVote();
//				forum.setVotecount(newVoteCount);
//				communityForumRepository.save(forum);
//				
//			}
//			
//		}
//		
//		
//		return false;
//	}
	
}
