package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPostDao;
import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;

@Service
@Transactional
public class PostServiceImpl implements IPostService {
 
	
   @Autowired
   IPostDao dao;
   
	@Override
	public Post insertPost(Post newPost) {
		return dao.save(newPost);
		
	}
	
	@Override
	public Post getPostById(Integer blogId) {
		return dao.getOne(blogId);
		
	}
	
	@Override
	public List<Post> getPublishedPosts() {
		return dao.findPublishedPost();
	}
	
	@Override
	public Post publishPost(Post p) {
		return dao.save(p);
	}
	
	@Override
	public Boolean removePost(int pId) {
		try {
			dao.deleteById(pId);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Post> getUnpublishedPost() {
		return dao.getUnpublishPosts();
		
	}
	
	@Override
	public List<Post> getPostUserById(User u) {
		// TODO Auto-generated method stub
		return dao.findByUser(u);
	}
	
	@Override
	public List<Post> getPostByCategory(Category c) {
		// TODO Auto-generated method stub
		return dao.findByCategory(c);
	}

	@Override
	public Post updatePost(Post p) {
		
		return dao.save(p);
	}
}
