package com.SobreMesa.Campus.Riddles.Services;


import com.SobreMesa.Campus.Riddles.Services.*;
import com.SobreMesa.Campus.Riddles.entity.Comment;
import com.SobreMesa.Campus.Riddles.entity.Riddle;
import com.SobreMesa.Campus.Riddles.entity.Riddler;
import com.SobreMesa.Campus.Riddles.repo.RiddlesRepository;
import com.SobreMesa.Campus.Riddles.repo.RiddlerRepository;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.LEAST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RiddlesService {
	
	@Autowired
	RiddlesRepository riddlesRepository;
	@Autowired
	private RiddlerRepository riddlerRepository;
	
	
	/*
	 * this following method uses "Method References" and "lambda expressions" which is 
	 * covered in a java brains video to learn later
	 */
	public List<Riddle> getAllRiddles(){
		/*
		 * This method uses RiddlesRepository which is an interface that utilizes 
		 * Object Relational Mapping (ORM) technique which converts data from a database
		 * into a class object. This method in the service calls that embedded findall()
		 * method
		 * 
		 * Args: 
		 * 		None
		 * 
		 * Returns:
		 * 		List of riddle objects filled with database data
		 */
		
		List<Riddle> riddles = new ArrayList<>();
		riddlesRepository.findAll()
		.forEach(riddles::add);
		
	
		return riddles;
	}
	public  List<Riddle> getRiddle(int riddleId) {
		List<Riddle> riddles = new ArrayList<>();
		Optional<Riddle> c =  riddlesRepository.findById(riddleId);
		
		//returns found forum or null
		riddles.add( c.orElse(null));
		 return riddles;
	}

	public String addRiddle(Riddle riddle) {
		
		/*
		 * This method takes a riddle object and adds it to the database. 
		 * This riddle object should come in the RequestBody of a POST method in 
		 * the controller that implements this method
		 * 
		 * Args:
		 * 		a Riddle object
		 * 
		 * Returns:
		 * 		None
		 * 
		 * 
		 * 
		 */
		
		
		
		Optional<Riddler> riddlerOptional = riddlerRepository.findById(riddle.getRiddler_id());
		
		
		if (riddlerOptional.isPresent())
		{
			Riddler riddler = riddlerOptional.get();
			try {
				riddle.setRiddlername(riddler.getUsername());	
				riddler.getRiddles().add(riddle);
				riddlerRepository.save(riddler);
			
			}catch (DataIntegrityViolationException e){
				return "Riddle with that name already exists, chose different name,";
			}
			
			return "success";
			
		}else {
		
			return "No riddler found for that id.";
		}
	}
	
	public String updateRiddle(Riddle riddle){
		/*
		 * This method updates an existing riddle, BUT DOESNT CHECK IF ITS EXISTS. 
		 * Since the riddle object already has the id, spring boot should know that 
		 * it already exists in the database so it will just update all the fields 
		 * of that object
		 * 
		 * Args:
		 * 		an existing riddle object
		 * 
		 * Returns:
		 * 		None
		 */
		
		try {
			riddlesRepository.save(riddle);
			
		}
		catch(NoSuchElementException e){
			return e.getMessage();
		}
		
		return "success";

	}

	public String deleteRiddle(int riddleId) {
		/*
		 * This method takes in a riddle id and removes it IF IT EXISTS
		 * 
		 * Args:
		 * 		a riddle object that exists
		 * 
		 * Returns: 
		 * 		None
		 */
		
		try {
			riddlesRepository.deleteById(riddleId);
		}catch (DataAccessException e) {
			return e.getMessage();
		}
		return "success";
		
	}
	
	
}