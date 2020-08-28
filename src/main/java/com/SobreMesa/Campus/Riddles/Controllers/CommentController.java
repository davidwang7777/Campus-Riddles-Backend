package com.SobreMesa.Campus.Riddles.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SobreMesa.Campus.Riddles.Services.CommentService;
import com.SobreMesa.Campus.Riddles.Services.CommunityForumService;
import com.SobreMesa.Campus.Riddles.dto.CommentResponse;
import com.SobreMesa.Campus.Riddles.dto.CommunityForumResponse;
import com.SobreMesa.Campus.Riddles.entity.Comment;
import com.SobreMesa.Campus.Riddles.entity.CommunityForum;

import Enum.ResponseStatus;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	CommentService cs; 
	
	@RequestMapping(method= RequestMethod.POST, value="community-forums/comments/submit")
	public CommunityForumResponse addComment(@RequestBody Comment comment) {
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
		String result = cs.addComment(comment);
		System.out.println(result);
		
		if (result.contains("success")) {
			return new CommunityForumResponse(ResponseStatus.SUCCESS,"Comment added",null);
		}else {
			return new CommunityForumResponse(ResponseStatus.FAILURE,result,null);
		}
		
	}
	
	@RequestMapping(method= RequestMethod.GET, value="community-forums/comments/{forum_id}")
	public CommentResponse getForumComments(@PathVariable int forum_id){
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
		List<Comment> comments = cs.getForumComments(forum_id);
		
		if (!comments.isEmpty()) {
			return new CommentResponse(ResponseStatus.SUCCESS, "Community Forums loaded successfully", comments);
		}else {
			return new CommentResponse(ResponseStatus.FAILURE, "No Community Forums found", comments);
		}
	}
	
	
	
	
//	@RequestMapping(method= RequestMethod.GET, value="api/community-forums/comments")
//	public CommentResponse getAllComments(){
//		/*
//		 * This method gets all forums available in the database
//		 * 
//		 * Args:
//		 * 		None
//		 * 
//		 * Returns:
//		 * 		returns a list of CommunityForum objects where each attribute in the object is taken
//		 * 		from the database
//		 */
//		List<Comment> comments = cs.getAllComments();
//		
//		if (!comments.isEmpty()) {
//			return new CommentResponse(ResponseStatus.SUCCESS, "Community Forums loaded successfully", comments);
//		}else {
//			return new CommentResponse(ResponseStatus.FAILURE, "No Community Forums found", comments);
//		}
//	}
}
