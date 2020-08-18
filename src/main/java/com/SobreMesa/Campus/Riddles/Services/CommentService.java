package com.SobreMesa.Campus.Riddles.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.Comment;
import com.SobreMesa.Campus.Riddles.entity.Hunter;
import com.SobreMesa.Campus.Riddles.entity.CommunityForum;
import com.SobreMesa.Campus.Riddles.repo.CommentRepository;
import com.SobreMesa.Campus.Riddles.repo.CommunityForumRepository;
import com.SobreMesa.Campus.Riddles.repo.HunterRepository;
@Service
public class CommentService {

	@Autowired 
	CommentRepository commentRepository;
	
	@Autowired
	CommunityForumRepository communityForumRepository;
	@Autowired 
	HunterRepository hunterRepository;
	
	
	public String addComment(Comment comment) {
		System.out.println("Got to save comm forum SERVICE");
		Optional<CommunityForum> forumOptional = communityForumRepository.findById(comment.getForum_id());
		
		if (forumOptional.isPresent() )
		{
			System.out.println("Got to save comm forum EXISTS");
			CommunityForum forum = forumOptional.get();
			Optional<Hunter> hunterOptional = hunterRepository.findById(forum.getHunter_id());
			
			if (hunterOptional.isPresent() )
			{
				System.out.println("Got to save hunter EXISTS");
				Hunter hunter = hunterOptional.get();
				try {
					
					comment.setHunter_username(hunter.getUsername());
					forum.getComments().add(comment);
					communityForumRepository.save(forum);
					System.out.println("Got to save comm forum SAVE");
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
	
	public List<Comment> getForumComments(int forum_id){
//		List<Comment> comments = new ArrayList<>();
//		commentRepository.findAllById(ids)
//		.forEach(comments::add);
//		return comments;
		
		List<Comment> comments = new ArrayList<>();
		comments = commentRepository.findAllByForum_id(forum_id);
		return comments;
	}
	
	
//	public List<Comment> getAllComments(){
//		List<Comment> comments = new ArrayList<>();
//		commentRepository.findAll()
//		.forEach(comments::add);
//		return comments;
//	}
	
}
