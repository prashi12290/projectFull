package com.app.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;
import com.app.service.ICategoryService;
import com.app.service.IPostService;
import com.app.service.IUserService;

@RestController
@CrossOrigin
public class PostController {
	
	@Autowired 
	IPostService service;
	@Autowired
	IUserService serviceUser;
	@Autowired
	ICategoryService catService;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	
	@PostMapping("/post/create/{userId}")
	public ResponseEntity<?> CreatePost(@PathVariable Integer userId,@RequestParam MultipartFile image,
			@RequestParam String blogTitle,
			@RequestParam String description,
			@RequestParam String body,
			@RequestParam String category){
		Post newPost=new Post(blogTitle,description,body);
		System.out.println("usrId"+userId);
		User u =serviceUser.GetUserById(userId);
		u.addPost(newPost);

		Category c = catService.getCategoryByName(category);
		c.addPost(newPost);
		
		try {
			newPost.setImage(image.getBytes());
		} catch (IOException e) {
			newPost.setImage(null);
			e.printStackTrace();
		}
		
		service.insertPost(newPost);
		 //if(newPost=null)
				//return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Post>(newPost, HttpStatus.OK);
	}
	
	@GetMapping("/post/{blogId}")
	public ResponseEntity<?> getPostById(@PathVariable Integer blogId){
		Post p = this.service.getPostById(blogId);
		p.setViews(p.getViews()+1);
		p=service.insertPost(p);
		if(p==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<Post>(p, HttpStatus.OK);
	}
	
	@GetMapping("/post/published")
	public ResponseEntity<?> getPublishedPosts(){
		List<Post> p = this.service.getPublishedPosts();
		if(p==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<List<Post>>(p, HttpStatus.OK);
	}
	
	@GetMapping("/post/unpublished")
	public ResponseEntity<?> getUnpublishedPosts(){
		List<Post> p = this.service.getUnpublishedPost();
		if(p==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Post>>(p, HttpStatus.OK);
	}
	
	@PutMapping("/post/publish")
	public ResponseEntity<?> publishPost(@RequestBody int pId){
		Post p = this.service.getPostById(pId);
		p.setPublished("Y");
		p = this.service.publishPost(p);
		if(p==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<Post>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("post/remove/{pId}")
	public ResponseEntity<?> removePost(@PathVariable int pId){
		Boolean removed = this.service.removePost(pId);
		if(!removed)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@GetMapping("/post/mypost/{userId}")
	public ResponseEntity<?> getPostByuserId(@PathVariable Integer userId){
		
		User u =serviceUser.GetUserById(userId);
		List<Post> p = this.service.getPostUserById(u);
		if(p==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<List<Post>>(p, HttpStatus.OK);
	}
	
	@GetMapping("post/category/{id}")
	public ResponseEntity<?> getPostByCategory(@PathVariable Integer id){
		
		Category c =catService.getCategoryById(id);
		List<Post> p = this.service.getPostByCategory(c);
		if(p==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<List<Post>>(p, HttpStatus.OK);
	}
	
	@PutMapping("/post/edit")
	public ResponseEntity<?> updatePost(@RequestParam MultipartFile image,
			@RequestParam String blogTitle,
			@RequestParam String description,
			@RequestParam String body,
			@RequestParam String category,@RequestParam Integer pId){
		Post p = this.service.getPostById(pId);
		p.setBlogTitle(blogTitle);
		p.setDescription(description);
		p.setBody(body);

		Category c = catService.getCategoryByName(category);
		c.addPost(p);
		try {
			p.setImage(image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPublished("N");
		p=service.insertPost(p);
	
		if(p==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<Post>(p, HttpStatus.OK);
	}
}
