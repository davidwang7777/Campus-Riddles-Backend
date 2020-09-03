package com.SobreMesa.Campus.Riddles.Controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.SobreMesa.Campus.Riddles.Services.RiddlesService;
import com.SobreMesa.Campus.Riddles.dto.CommunityForumResponse;
import com.SobreMesa.Campus.Riddles.dto.RiddlesResponse;
import com.SobreMesa.Campus.Riddles.entity.*;

import Enum.ResponseStatus;


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

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GetRiddles {
	
	@Autowired
	RiddlesService rs; 
	
	@RequestMapping(method= RequestMethod.POST, value="riddles")
	public RiddlesResponse subscribeToRiddle(@RequestParam("riddle_id") int riddle_id, @RequestParam("hunter_id") int hunter_id) {
	   /* this method takes a json structure that is created in the front end that represents
		*	a riddle object. it then gets added to the database
		*
		*	Args:
		*		Riddle json data found in RequestBody of this POST call. Automatically converted to a 
		*		Riddle object by spring boot
		*
		*	Returns:
		*		RiddlesResponse
		*
		*/
		
		//System.out.println("IN SUBSCRIBE FUNCTION");
		
		String result = rs.subscribeToRiddle(hunter_id, riddle_id);
		
		if (result.contains("success") ) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Riddle added successfully", null);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, result, null);
		}
	}
	
	@RequestMapping(method= RequestMethod.POST, value="riddles/attempt")
	public RiddlesResponse attemptRiddle(@RequestParam("answer") String answer, @RequestParam("riddle_id") int riddle_id) {
	   /* this method takes a json structure that is created in the front end that represents
		*	a riddle object. it then gets added to the database
		*
		*	Args:
		*		Riddle json data found in RequestBody of this POST call. Automatically converted to a 
		*		Riddle object by spring boot
		*
		*	Returns:
		*		RiddlesResponse
		*
		*/
		
		//System.out.println("IN SUBSCRIBE FUNCTION");
		
		String result = rs.attemptRiddle(answer, riddle_id);
		if (result.contains("success") ) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Guessed successfully", null);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, result, null);
		}
	}
	
	//Level level, int riddle_id
	
	@RequestMapping(method= RequestMethod.POST, value="riddles/levels")
	public RiddlesResponse addRiddleLevel(@RequestBody Level level , @RequestParam("riddle_id") int riddle_id) {
	   /* this method takes a json structure that is created in the front end that represents
		*	a riddle object. it then gets added to the database
		*
		*	Args:
		*		Riddle json data found in RequestBody of this POST call. Automatically converted to a 
		*		Riddle object by spring boot
		*
		*	Returns:
		*		RiddlesResponse
		*
		*/
		
		String result = rs.postRiddleLevel(level, riddle_id);
		
		if (result.contains("success") ) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Level added successfully", null);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, result, null);
		}
	}
	
	
	
	
	@RequestMapping(method= RequestMethod.GET, value="riddles/subscribe/{hunter_id}")
	public RiddlesResponse getAllSubscribedRiddles(@PathVariable int hunter_id){
		/*
		 * This method gets all riddles available in the database
		 * 
		 * Args:
		 * 		None
		 * 
		 * Returns:
		 * 		returns RiddlesResponse with list of Riddle objects where each attribute in the object is taken
		 * 		from the database
		 */
		List<Riddle> riddles =  rs.getAllSubscribedRiddles(hunter_id);
	
		
		if (!riddles.isEmpty()) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Riddles loaded successfully",riddles);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, "No Riddles loaded", null);
		}
	}

	@RequestMapping(method= RequestMethod.POST, value="riddles/submit")
	public RiddlesResponse addRiddle(@RequestBody Riddle riddle) {
	   /* this method takes a json structure that is created in the front end that represents
		*	a riddle object. it then gets added to the database
		*
		*	Args:
		*		Riddle json data found in RequestBody of this POST call. Automatically converted to a 
		*		Riddle object by spring boot
		*
		*	Returns:
		*		RiddlesResponse
		*
		*/
		
		String result = rs.addRiddle(riddle);
		
		if (result.contains("success") ) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Riddle added successfully", null);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, result, null);
		}
	}

	@GetMapping("riddles")
	public RiddlesResponse getRiddles(@RequestParam("sort") String order){
		/*
		 * This method gets all riddles available in the database
		 * 
		 * Args:
		 * 		None
		 * 
		 * Returns:
		 * 		returns RiddlesResponse with list of Riddle objects where each attribute in the object is taken
		 * 		from the database
		 */

		List<Riddle> riddles = null;
		
		switch (order) {
			case "Difficulty (high - low)":
				riddles = rs.getRiddlesByDscDifficulty();
				break;
			case "Difficulty (low - high)":
				riddles = rs.getRiddlesByAscDifficulty();
				break;
			case "Oldest":
				riddles = rs.getRiddlesByOldest();
				break;
			case "Newest":
				riddles = rs.getRiddlesByNewest();
				break;
			default:
				break;
		}
	
		if (riddles != null) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Riddles loaded successfully",riddles);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, "No Riddles loaded", null);
		}
	}	
	
	@RequestMapping("riddles/newest")
	public RiddlesResponse getTopThreeNewestRiddles(){
		/*
		 * This method gets all riddles available in the database
		 * 
		 * Args:
		 * 		None
		 * 
		 * Returns:
		 * 		returns RiddlesResponse with list of Riddle objects where each attribute in the object is taken
		 * 		from the database
		 */
		List<Riddle> riddles =  rs.getTopThreeNewestRiddles();
	
		
		if (!riddles.isEmpty()) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Riddles loaded successfully",riddles);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, "No Riddles loaded", null);
		}
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value="riddles/{id}")
	public RiddlesResponse getRiddle(@PathVariable int id){
		/*
		 * This method gets all community forums available in the database
		 * 
		 * Args:
		 * 		None
		 * 
		 * Returns:
		 * 		returns a list of CommunityForum objects where each attribute in the object is taken
		 * 		from the database
		 */
		
		List<Riddle> riddles = rs.getRiddle(id);
		
		if (!riddles.isEmpty()) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Riddle loaded successfully", riddles);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, "No Riddle found", riddles);
		}
		
	}
	
	//@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(method=RequestMethod.PUT, value="riddles")
	public RiddlesResponse updateRiddle(@RequestBody Riddle riddle) {
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
		//System.out.println("Called the put function");
		if (rs.updateRiddle(riddle).contains("success")) {
			return new RiddlesResponse(ResponseStatus.SUCCESS,"Riddle updated successfully", null);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE,"Riddle not updated", null);
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="riddles/{id}")
	public RiddlesResponse deleteRiddle(@PathVariable int riddleId) {
		/*
		 * This method takes riddle id and deletes that riddle if it
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
		if (rs.deleteRiddle(riddleId).contains("success")) {
			return new RiddlesResponse(ResponseStatus.SUCCESS, "Riddle deleted successfully", null);
		}else {
			return new RiddlesResponse(ResponseStatus.FAILURE, "No Riddle deleted" , null);
		}
	}
//	
	
//	@PostMapping(value = "api/Riddles", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void addRiddle(@RequestBody Riddle riddle){
//		/*
//		 * This method takes a json structure of a riddle.
//		 * TODO: find difference between post and put
//		 * 
//		 * Args:
//		 * 		Riddle json data
//		 * 
//		 * Returns:
//		 * 		None
//		 */
//		rs.addRiddle(riddle);
//	}
	
	
	
//	

	
}
