package com.SobreMesa.Campus.Riddles.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SobreMesa.Campus.Riddles.Services.CommunityForumService;
import com.SobreMesa.Campus.Riddles.entity.CommunityForum;

@RestController
public class CommunityForumController {

	
	@Autowired
	CommunityForumService cf; 
	
	@RequestMapping(method= RequestMethod.POST, value="api/community-forums")
	public void addRiddle(@RequestBody CommunityForum communityForum) {
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
		
		cf.addCommunityForum(communityForum);
	}
	
	@RequestMapping(method= RequestMethod.GET, value="api/community-forums")
	public List<CommunityForum> getCommunityForums(){
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
		return cf.getCommunityForums();
	}
}
