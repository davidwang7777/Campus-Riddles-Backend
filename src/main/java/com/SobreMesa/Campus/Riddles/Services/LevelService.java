package com.SobreMesa.Campus.Riddles.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.Level;
import com.SobreMesa.Campus.Riddles.entity.Riddle;
import com.SobreMesa.Campus.Riddles.repo.RiddlesRepository;

@Service
public class LevelService {

	@Autowired RiddlesRepository riddlesRepository;
	
	
	public String postRiddleLevel(Level level, int riddle_id) {
		
		
		Optional<Riddle> riddleOptional = riddlesRepository.findById(riddle_id);
		
		if (riddleOptional.isPresent()) {
			Riddle riddle = riddleOptional.get(); //unwrap riddle here
			try {
			riddle.getLevels().add(level);
			riddlesRepository.save(riddle);
			}catch (DataIntegrityViolationException e){
				System.out.println("cant save level for riddles");
			}
			
		}else {
			return "No riddle found for that id";
		}
		
		
		return "success";
	}
	
}
