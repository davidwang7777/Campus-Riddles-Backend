package com.SobreMesa.Campus.Riddles.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.SobreMesa.Campus.Riddles.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{
	
	
	//@Query( value = "SELECT forum_id FROM USERS u WHERE u.status = 1",   nativeQuery = true)
	
	@Query( value = "SELECT * FROM campusriddles.comments c WHERE c.forum_id = ?1", nativeQuery = true )
	public List<Comment> findAllByForum_id(int forum_id);
}
