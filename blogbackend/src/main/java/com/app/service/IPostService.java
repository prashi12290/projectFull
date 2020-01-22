package com.app.service;

import com.app.entity.Post;

public interface IPostService {
	
	public Post insertPost(Post newPost);

	public Post getPostById(Integer blogId);

}
