package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Category;
import com.app.entity.User;

public interface ICategoryDao extends JpaRepository<Category, Integer> {
	Category findByName(String name);
}
