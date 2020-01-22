package com.app.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PostDto;
import com.app.dto.UserDto;
import com.app.entity.Post;
import com.app.entity.User;
import com.app.service.IUserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	IUserService service;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestParam String email, @RequestParam String password) {
		 User u = service.Login(email, password);
		 if(u==null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> SignUpUser(@RequestBody UserDto details){
		if(details.getPassword().equals(details.getConfirm())) { 
		User newUser = new User(details);
		service.createUser(newUser);
		}
		else {
				return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
}
