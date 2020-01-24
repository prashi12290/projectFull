package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Category;
import com.app.entity.Post;
import com.app.entity.User;

public interface IPostDao extends JpaRepository<Post, Integer>{
	@Query(value = "select * from post p left outer join user u on p.user_id=u.user_id where post_id=?1",nativeQuery = true)
	Post getUserAndPost(Integer blogId);

	@Query("SELECT p from Post p where p.published='N'")
	List<Post> getUnpublishPosts();
	
	@Query("SELECT p from Post p where p.published='Y'")
	List<Post> findPublishedPost();
	
	List<Post> findByUser(User u);
	
	List<Post> findByCategory(Category c);
}
