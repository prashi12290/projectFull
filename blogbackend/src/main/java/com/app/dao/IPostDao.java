package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Post;

public interface IPostDao extends JpaRepository<Post, Integer>{
	@Query(value = "select * from post p left outer join user u on p.user_id=u.user_id where post_id=?1",nativeQuery = true)
	Post getUserAndPost(Integer blogId);
}
