package com.pavan.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavan.dao.CategoryDao;
import com.pavan.manager.CategoryManager;
import com.pavan.model.Category;

@Service
public class CategoryManagerImpl implements CategoryManager {
	
	@Autowired
	private CategoryDao categoryDao ;

	@Transactional
	public void insertCategory(Category category) {
		categoryDao.insertCategory(category);
	}

	@Transactional
	public List<Category> findAllCategories() {
		return categoryDao.findAllCategory();
	}
	
	

}
