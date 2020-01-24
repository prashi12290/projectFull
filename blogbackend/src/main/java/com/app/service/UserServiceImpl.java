package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.entity.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDao dao;

	@Override
	public User Login(String email, String password) {
		return dao.findByEmailAndPassword(email, password);
	}

	@Override
	public User createUser(User newUser) {
		return dao.save(newUser);
	}

	@Override
	public List<User> findUserByName(String uname) {
		// TODO Auto-generated method stub
		return dao.findByName(uname);
	}

	@Override
	public User GetUserById(Integer id) {
		return dao.getOne(id);
	}

	@Override
	public boolean removeUser(Integer userid) {
		try {
			dao.removeUser(userid);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean makeAdmin(Integer userid) {
		try {
			dao.updateUser(userid);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
