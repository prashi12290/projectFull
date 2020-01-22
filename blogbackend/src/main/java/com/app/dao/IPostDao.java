package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Post;

public interface IPostDao extends JpaRepository<Post, Integer>{

}
