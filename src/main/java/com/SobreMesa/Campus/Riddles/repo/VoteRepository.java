package com.SobreMesa.Campus.Riddles.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SobreMesa.Campus.Riddles.entity.Comment;
import com.SobreMesa.Campus.Riddles.entity.Vote;

public interface VoteRepository extends CrudRepository<Vote, Integer>{
	
	
	
	//query 
	//SELECT * FROM campusriddles.votes v WHERE v.hunter_username="hunterExample" AND v.fk_vote_forum=39; 	
	@Query(value ="SELECT * FROM campusriddles.votes v WHERE v.hunter_username=?1 AND v.fk_vote_forum=?2", nativeQuery = true )
	public Optional<Vote> findByUsernameAndForumId(String hunter_username, int fk_vote_forum);
	
	
	@Query(value ="SELECT vote FROM campusriddles.votes v WHERE v.fk_vote_forum=?1", nativeQuery = true )
	public List<Integer> findVotesValuesByForumId(int fk_vote_forum);
	
}
