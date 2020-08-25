package com.SobreMesa.Campus.Riddles.Controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SobreMesa.Campus.Riddles.Services.CommunityForumService;
import com.SobreMesa.Campus.Riddles.dto.CommunityForumResponse;
import com.SobreMesa.Campus.Riddles.dto.RiddlesResponse;
import com.SobreMesa.Campus.Riddles.entity.CommunityForum;

import Enum.ResponseStatus;

@RestController
public class CommunityForumController {

	
	@Autowired
	CommunityForumService cf; 
	
	@RequestMapping(method= RequestMethod.POST, value="api/community-forums/submit")
	public CommunityForumResponse addCommunityForum(@RequestBody CommunityForum communityForum) {
	   /* this method takes a json structure that is created in the front end that represents
		*	a CommunityForum object. it then gets added to the database
		*
		*	Args:
		*		Riddle json data found in RequestBody of this POST call. Automatically converted to a 
		*		CommunityForum object by spring boot
		*
		*	Returns:
		*		None
		*/
		
		//System.out.println(communityForum.getContent());
		String result = cf.addCommunityForum(communityForum);
		
		//System.out.println("POSTED at:"+ java.time.Instant.now());
		
		
		
		if (result.contains("success")) {
			return new CommunityForumResponse(ResponseStatus.SUCCESS,"Community Forum added",null);
		}else {
			return new CommunityForumResponse(ResponseStatus.FAILURE,result,null);
		}
		
	}
	
	@RequestMapping(method= RequestMethod.GET, value="api/community-forums")
	public CommunityForumResponse getAllCommunityForums(){
		/*
		 * This method gets all forums available in the database
		 * 
		 * Args:
		 * 		None
		 * 
		 * Returns:
		 * 		returns a list of CommunityForum objects where each attribute in the object is taken
		 * 		from the database
		 */
		
		//System.out.println("IN FORUMS CONTROLLER - before call");
		List<CommunityForum> communityForums = cf.getAllCommunityForums();
		
		//System.out.println(communityForums.get(1).getComments());
		
		
		//System.out.println("IN FORUMS CONTROLLER - after call");
		
		if (!communityForums.isEmpty()) {
			return new CommunityForumResponse(ResponseStatus.SUCCESS, "Community Forums loaded successfully", communityForums);
		}else {
			return new CommunityForumResponse(ResponseStatus.FAILURE, "No Community Forums found", communityForums);
		}
		
		
	}
	@RequestMapping(method= RequestMethod.GET, value="api/community-forums/{id}")
	public CommunityForumResponse getCommunityForum(@PathVariable int id){
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
		
		List<CommunityForum> communityForums = cf.getCommunityForum(id);
		
		if (!communityForums.isEmpty()) {
			return new CommunityForumResponse(ResponseStatus.SUCCESS, "Community Forums loaded successfully", communityForums);
		}else {
			return new CommunityForumResponse(ResponseStatus.FAILURE, "No Community Forums found", communityForums);
		}
		
	}
	
	
//	@RequestMapping(method= RequestMethod.GET, value="api/community-forums/{keyword}")
//	public List<CommunityForum> getCommunityForums(@PathVariable String keyword){
//		/*
//		 * This method gets all community forums available in the database
//		 * 
//		 * Args:
//		 * 		None
//		 * 
//		 * Returns:
//		 * 		returns a list of CommunityForum objects where each attribute in the object is taken
//		 * 		from the database
//		 */
//		
//		return cf.getCommunityForumByKeyword(keyword);
//	}
	
	@RequestMapping(method=RequestMethod.PUT, value="api/community-forums")
	public CommunityForumResponse updateCommunityForum(@RequestBody CommunityForum communityForum) {
		/*
		 * This method updates community forum in the database given id and new forum data
		 * 
		 * Args:
		 * 		None
		 * 
		 * Returns:
		 * 		returns a list of CommunityForum Repsonse
		 */
		
		
		if (cf.updateCommunityForum(communityForum).contains("success")) {
			return new CommunityForumResponse(ResponseStatus.SUCCESS,"Community Forum updated successfully", null);
		}else {
			return new CommunityForumResponse(ResponseStatus.FAILURE,"Community Forum not updated", null);
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="api/community-forums/{communityForumId}")
	public CommunityForumResponse deleteCommunityForum(@PathVariable int communityForumId) {
		/*
		 * This method takes community forum id of a forum and deletes that forum if it
		 * exists. 
		 * TODO: we can probably change the parameters of this so that it only takes in the 
		 * forum ID so spring locates that specific forum and deletes it instead of passing
		 * in the whole object
		 * 
		 * Args:
		 * 		Riddle json data found in RequestBody of this DELETE call
		 * 
		 * Returns:
		 * 		None
		 */
		if (cf.deleteCommunityForum(communityForumId).contains("success")){
			return new CommunityForumResponse(ResponseStatus.SUCCESS,"Community Forum added",null);
		}else {
			return new CommunityForumResponse(ResponseStatus.FAILURE,"No Community Forum deleted",null);
		}
		
	}
	
	
	
}
