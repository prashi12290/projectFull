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
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return dao.findAll();
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
	

}
