package com.app.service;

import java.util.List;

import com.app.entity.Post;

public interface IPostService {
	
	public Post insertPost(Post newPost);
	
	public Post getPostById(Integer blogId);

	public List<Post> getAllPost();

}
