package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPostDao;
import com.app.entity.Post;

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

}
