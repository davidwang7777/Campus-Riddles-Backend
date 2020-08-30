package com.SobreMesa.Campus.Riddles.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SobreMesa.Campus.Riddles.entity.CommunityForum;

public interface CommunityForumRepository extends CrudRepository<CommunityForum, Integer>{
	//public List<CommunityForum> findByTitle(String title);
	
	@Query(value="SELECT * FROM campusriddles.community_forum ORDER BY votecount", nativeQuery =true)
	List<CommunityForum> findForumsByAscVotecount();
	
	@Query(value="SELECT * FROM campusriddles.community_forum ORDER BY votecount DESC", nativeQuery =true)
	List<CommunityForum> findForumsByDscVotecount();
	
	@Query(value="SELECT * FROM campusriddles.community_forum ORDER BY created DESC", nativeQuery =true)
	List<CommunityForum> findForumsByNewest();
	
}
 