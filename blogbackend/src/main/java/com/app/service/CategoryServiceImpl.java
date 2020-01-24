package com.app.service;

import java.util.List;

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

	@Override
	public Category addCategory(Category category) {
		
		return dao.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		
		return dao.findAll();
	}
}
