package com.pavan.manager;

import java.util.List;

import com.pavan.model.Category;

public interface CategoryManager {
	
	 void insertCategory(Category category);

	  List<Category> findAllCategories();

}
