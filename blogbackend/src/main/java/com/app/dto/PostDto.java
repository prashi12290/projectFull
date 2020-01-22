package com.app.dto;

import java.io.File;

import com.app.entity.Category;

public class PostDto {
	private String blogTitle,description,body;
	//private File filename;
	//private int userId;
	public Category category;
	
	public PostDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PostDto(String blogTitle, String description, String body, Category category/* File filename, int userId*/) {
		super();
		this.blogTitle = blogTitle;
		this.description = description;
		this.body = body;
		this.category = category;
		//this.filename = filename;
		//this.userId = userId;
	}



	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String heading) {
		this.blogTitle = blogTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	/*public File getFilename() {
		return filename;
	}

	public void setFilename(File filename) {
		this.filename = filename;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}*/
	
	
	
	
	
	
}
