package com.onlinepharmacy.service;


import java.util.List;

import com.onlinepharmacy.model.Product;


public interface ProductService {

	List<Product> getAll();
	
	List<Product> getAllByCategory(int categoryId);

	Product getById(int id);

	Product add(int categoryId, Product p);

	Product update(int productId, Product p);

	void delete(int productId);

}
