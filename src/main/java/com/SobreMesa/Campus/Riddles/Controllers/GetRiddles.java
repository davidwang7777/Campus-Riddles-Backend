package com.SobreMesa.Campus.Riddles.Controllers;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SobreMesa.Campus.Riddles.Services.RiddlesService;
import com.SobreMesa.Campus.Riddles.entity.*;


/*
 * @RequestBody 
 * Explanation: tells the method that the parameter it is about to receive needs to be converted
 * into an object. and the information necessary to create that object will be inside of the 
 * requestbody of the http call and it will be in the form of json. 
 * 
 * What does it do in this class?
 * meaning that whoever sends it
 * (angular) will first need to create a json that represents the new riddle or object being made
 * and send that json over in the request body
 * 
 * 
 * @PathVariable tells the method that the method parameter can be found inside of the request 
 * url in between the brackets {id}. it is possible to pass multiple and it is possible to name the
 * thing in between the {} different from the parameter variable name
 * 
 * What does it do in this class?
 * it just tells the updateRiddles() method that its parameter id will be found and named exactly
 * the same in the URL request its supposed to be mapped to
 * 
 * @Autowired 
 * injects an already existing instance of an object into this class so we're using it, but
 * it already exists elsewhere
 * 
 * 
 */


@RestController
public class GetRiddles {
	
	@Autowired
	RiddlesService rs; 
	
	
	@RequestMapping("/Riddles")
	public List<Riddle> getAllRiddles(){
		/*
		 * This method gets all riddles available in the database
		 * 
		 * Args:
		 * 		None
		 * 
		 * Returns:
		 * 		returns a list of Riddle objects where each attribute in the object is taken
		 * 		from the database
		 */
		return rs.getAllRiddles();
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/Riddles/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateRiddle(@RequestBody Riddle riddle) {
		/*
		 * This method is first gets the json structure in the RequestBody. That json structure
		 * gets automatically converted to a riddle object by spring. that riddle object 
		 * is passed to the service
		 * 
		 * Args:
		 * 		riddle variable is built in a json file in the front end (Angular) and its 
		 * 		passed in as a parameter in the RequestBody of the POST or PUT request.
		 * 
		 * Returns:
		 * 		None
		 */
		rs.updateRiddle(riddle);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Riddles/{id}")
	public void deleteRiddle(@RequestBody Riddle riddle) {
		/*
		 * This method takes a json structure of a riddle and deletes that riddle if it
		 * exists. 
		 * TODO: we can probably change the parameters of this so that it only takes in the 
		 * riddle ID so spring locates that specific riddle and deletes it instead of passing
		 * in the whole object
		 * 
		 * Args:
		 * 		Riddle json data found in RequestBody of this DELETE call
		 * 
		 * Returns:
		 * 		None
		 */
		rs.deleteRiddle(riddle);
	}
	
	
	@RequestMapping(method= RequestMethod.POST, value="/Riddles")
	public void addRiddle(@RequestBody Riddle riddle) {
	   /* this method takes a json structure that is created in the front end that represents
		*	a riddle object. it then gets added to the database
		*
		*	Args:
		*		Riddle json data found in RequestBody of this POST call. Automatically converted to a 
		*		Riddle object by spring boot
		*
		*	Returns:
		*		None
		*/
		rs.addRiddle(riddle);
	}
	
}
