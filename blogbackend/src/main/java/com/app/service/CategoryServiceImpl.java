package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICategoryDao;
import com.app.entity.Category;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	ICategoryDao dao;
	
	@Override
	public Category getCategoryByName(String name) {
		return dao.findByName(name);
	}
}
