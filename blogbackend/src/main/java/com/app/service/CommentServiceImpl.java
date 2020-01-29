package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICommentDao;
import com.app.entity.Comments;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentDao dao;

	@Override
	public Comments addComment(Comments newComment) {
		return dao.save(newComment);
	}
}
