package com.onlinepharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlinepharmacy.model.Product;


public interface ProductDAO extends CrudRepository<Product, Integer>{
	
	
	
	List<Product> findAllByCategoryCategoryId(int categoryId);
	
	
	
}
