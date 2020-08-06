package com.SobreMesa.Campus.Riddles.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SobreMesa.Campus.Riddles.entity.CommunityForum;

public interface CommunityForumRepository extends CrudRepository<CommunityForum, Integer>{
	//public List<CommunityForum> findByTitle(String title);
	
}
 