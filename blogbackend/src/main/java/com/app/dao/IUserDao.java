package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Post;
import com.app.entity.User;

public interface IUserDao extends JpaRepository<User, Integer> {
	
	User findByEmailAndPassword(String email,String password);

	List<User> findByName(String uname);
	
	@Modifying
	@Query("update User u set u.deleted = 'Y' where u.userId = ?1")
	int removeUser(Integer userId);
}
