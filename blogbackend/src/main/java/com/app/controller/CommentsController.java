package com.app.controller;



import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Comments;
import com.app.entity.Post;
import com.app.entity.User;
import com.app.service.ICommentService;
import com.app.service.IPostService;
import com.app.service.IUserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class CommentsController {
	
	@Autowired
	ICommentService service;
	
	@Autowired
	IPostService postServie;
	
	@Autowired
	IUserService userService;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	
	@PostMapping("/comment/create")
	public ResponseEntity<?> addComment(@RequestParam Integer postid, @RequestParam Integer userid,@RequestParam String cmnt) {
		System.out.println("post"+postid);
		System.out.println("user"+userid);
		System.out.println("comment"+cmnt);
		Post p = postServie.getPostById(postid);
		User u = userService.GetUserById(userid);
		Comments newComment = new Comments(u, p, cmnt);
		
		newComment = service.addComment(newComment);
		 if(newComment==null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
