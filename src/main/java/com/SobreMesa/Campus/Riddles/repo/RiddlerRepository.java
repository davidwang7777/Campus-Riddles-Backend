package com.SobreMesa.Campus.Riddles.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SobreMesa.Campus.Riddles.entity.Comment;
import com.SobreMesa.Campus.Riddles.entity.Riddler;

public interface RiddlerRepository extends CrudRepository<Riddler,Integer>{
	@Query( value = "SELECT school FROM campusriddles.riddlers", nativeQuery = true )
	public List<String> findAllSchools();
}
