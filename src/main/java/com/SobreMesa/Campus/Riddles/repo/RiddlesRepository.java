package com.SobreMesa.Campus.Riddles.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.SobreMesa.Campus.Riddles.entity.Riddle;


public interface RiddlesRepository extends CrudRepository<Riddle, Integer> {
	
	public List<Riddle> findByName(String name);

}
