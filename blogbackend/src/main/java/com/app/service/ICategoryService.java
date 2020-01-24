package com.app.service;

import java.util.List;

import com.app.entity.Category;

public interface ICategoryService {
	Category getCategoryByName(String name);
	Category addCategory(Category c);



	List<Category> getAllCategories();



	Category getCategoryById(Integer id);

}
