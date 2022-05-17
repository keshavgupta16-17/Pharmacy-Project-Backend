package com.onlinepharmacy.service;


import java.util.List;

import com.onlinepharmacy.model.Category;
import com.onlinepharmacy.model.Product;


public interface CategoryService {
	
	Category getById(int id);
	
	List<Category> getAll();
	
	Category add(Category category);
	
	Category update(int categoryId, Category category);
	
	void delete(int categoryId);
	

}

