package com.SobreMesa.Campus.Riddles.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.SobreMesa.Campus.Riddles.entity.Comment;
import com.SobreMesa.Campus.Riddles.entity.Riddle;


public interface RiddlesRepository extends CrudRepository<Riddle, Integer> {
	
	//public List<Riddle> findByName(String name);
	
	
	@Query(value="SELECT * FROM campusriddles.riddles order by created desc limit 3", nativeQuery =true)
	List<Riddle> findTopThreeNewestRiddles();
	
	
	@Query(value="SELECT * FROM campusriddles.riddles ORDER BY difficulty", nativeQuery =true)
	List<Riddle> findRiddlesByAscDifficulty();
	
	
	@Query(value="SELECT * FROM campusriddles.riddles ORDER BY difficulty DESC", nativeQuery =true)
	List<Riddle> findRiddlesByDscDifficulty();
	
	
	
	@Query(value="SELECT * FROM campusriddles.riddles ORDER BY created DESC", nativeQuery =true)
	List<Riddle> findRiddlesByNewest();
	
//	
//	@Query( value = "SELECT * FROM campusriddles.comments c WHERE c.forum_id = ?1", nativeQuery = true )
//	public List<Comment> findAllByForum_id(int forum_id);

}
