package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;
import com.app.service.ICategoryService;

@RestController
@CrossOrigin
public class CategoryController {
	
	@Autowired
	ICategoryService catService;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + catService);
	}
	
	@PostMapping("/addCategory")
	public ResponseEntity<?> addCategory(@RequestParam String name, @RequestParam String description) {
		 Category c = new Category(name, description);
		 Category category=this.catService.addCategory(c);
		 if(c==null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	@GetMapping("/categories")
	public ResponseEntity<?> getAllCategories(){
		List<Category> c = this.catService.getAllCategories();
		if(c==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	return new ResponseEntity<List<Category>>(c, HttpStatus.OK);
	}
	
	

}
