package com.SobreMesa.Campus.Riddles.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.SobreMesa.Campus.Riddles.entity.Riddle;


public interface RiddlesRepository extends CrudRepository<Riddle, Integer> {
	
	//public List<Riddle> findByName(String name);
	
	//SELECT * FROM campusriddles.riddles order by created desc limit 3
	@Query(value="SELECT * FROM campusriddles.riddles order by created desc limit 3", nativeQuery =true)
	List<Riddle> findTopThreeNewestRiddles();

}
