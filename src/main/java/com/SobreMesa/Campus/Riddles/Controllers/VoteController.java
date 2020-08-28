package com.SobreMesa.Campus.Riddles.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SobreMesa.Campus.Riddles.Services.VoteService;
import com.SobreMesa.Campus.Riddles.dto.CommunityForumResponse;
import com.SobreMesa.Campus.Riddles.entity.Vote;

import Enum.ResponseStatus;

@RestController
@RequestMapping("/api")
public class VoteController {

	
	@Autowired
	VoteService vs;
	
	@RequestMapping(method= RequestMethod.POST, value="community-forums/vote")
	public CommunityForumResponse addVote(@RequestBody Vote vote) {
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
		System.out.println("got before service call");
		//System.out.println(communityForum.getContent());
		String result = vs.addVote(vote);
		System.out.println("got after service call");
		
		if (result.contains("success")) {
			return new CommunityForumResponse(ResponseStatus.SUCCESS,"Vote added",null);
		}else {
			return new CommunityForumResponse(ResponseStatus.FAILURE,result,null);
		}
		
	}
}
