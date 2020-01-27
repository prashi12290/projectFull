package com.app.service;

import java.util.List;

import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;

public interface IPostService {
	
	public Post insertPost(Post newPost);
	
	public Post getPostById(Integer blogId);

	public List<Post> getPublishedPosts();

	public Post publishPost(Post p);

	public Boolean removePost(int pId);

	public List<Post> getUnpublishedPost();
	
	public List<Post> getPostUserById(User u);

	public List<Post> getPostByCategory(Category c);

	public Post updatePost(Post p);

}
