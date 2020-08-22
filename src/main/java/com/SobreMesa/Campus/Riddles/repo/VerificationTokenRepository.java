package com.SobreMesa.Campus.Riddles.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.SobreMesa.Campus.Riddles.entity.Riddle;
import com.SobreMesa.Campus.Riddles.entity.VerificationToken;


public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Integer> {
	
	//public List<Riddle> findByName(String name);

}
