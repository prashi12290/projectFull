package com.app.service;

import java.util.List;

import com.app.entity.User;

public interface IUserService {
	
	public User Login(String email,String password);
	public User GetUserById(Integer id);
	public User createUser(User newUser);
	public List<User> findUserByName(String uname);
	public boolean removeUser(Integer userid);
}
