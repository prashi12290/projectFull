package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Comments;

public interface ICommentDao extends JpaRepository<Comments, Integer>{

}
