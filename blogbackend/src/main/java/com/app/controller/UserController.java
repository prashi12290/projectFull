package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
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
	public ResponseEntity<?> SignUpUser(@RequestParam String name,@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword,@RequestParam String gender,@RequestParam long phone,@RequestParam MultipartFile image){
		UserDto details = new UserDto(name, email, password, confirmPassword, gender, phone);
		if(details.getPassword().equals(details.getConfirmPassword())) { 
		User newUser = new User(details);
		try {
			newUser.setImage(image.getBytes());
		} catch (IOException e) {
			newUser.setImage(null);
			e.printStackTrace();
		}
		service.createUser(newUser);
		}
		else {
				return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@GetMapping("/user/name/{uname}")
	public ResponseEntity<?> findUserByName(@PathVariable String uname) {
		
		List<User> userlist = service.findUserByName(uname);
		 if(userlist==null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);
	}

	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userid) {
		
		boolean removed = this.service.removeUser(userid);
		if(!removed)
				return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<?> makeUserAdmin(@PathVariable Integer userid) {
		System.out.println("userid"+userid);
		boolean updated = this.service.makeAdmin(userid);
		if(!updated)
				return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
