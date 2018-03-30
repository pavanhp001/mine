package com.pavan.dao;

import java.util.List;

import com.pavan.model.Category;

public interface CategoryDao {
	
	void insertCategory(Category category);

	List<Category> findAllCategory();

}
