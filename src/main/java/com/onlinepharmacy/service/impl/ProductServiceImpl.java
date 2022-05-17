package com.onlinepharmacy.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.onlinepharmacy.dao.CategoryDAO;
import com.onlinepharmacy.dao.ProductDAO;
import com.onlinepharmacy.exception.NullObjectException;
import com.onlinepharmacy.exception.ResourceNotFoundException;
import com.onlinepharmacy.model.Category;
import com.onlinepharmacy.model.Product;
import com.onlinepharmacy.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		Iterable<Product> it = productDAO.findAll();
		it.forEach((product) -> {
			products.add(product);
		});
		return products;
		
		
	
		
	}
	
	@Override
	public Product getById(int id) {
		Product product = null;
		Optional<Product> opt = productDAO.findById(id);
		if(opt.isEmpty()) {
			throw new ResourceNotFoundException("Product", "Product Id", id);
		}
		else {
			product = opt.get();
		}
		return product;
	}
	
	@Override
	public Product add(int categoryId, Product product) {
		if(product == null) {
			throw new NullObjectException("Product");
		}
		
		Category category = null;
		Optional<Category> opt = categoryDAO.findById(categoryId);
		if(opt.isEmpty()) {
			throw new ResourceNotFoundException("Category", "Category Id", categoryId);
		}
		
		category = opt.get();
		product.setCategory(category);
		return productDAO.save(product);
	}
	
	@Override
	public Product update(int productId, Product p) {
		if(p == null) {
			throw new NullObjectException("Product");
		}
		
		Optional<Product> opt = productDAO.findById(productId);
		if(opt.isEmpty()) {
			throw new ResourceNotFoundException("Product", "Product Id", productId);
		}
		Product prod = productDAO.save(p);
		
		return prod;	
	}
	
	@Override
	public void delete(int productId) {
		Optional<Product> opt = productDAO.findById(productId);
		if(opt.isEmpty()) {
			throw new ResourceNotFoundException("Product", "Product Id", productId);
		}
		productDAO.delete(new Product(productId,"","", 0));
	}

	@Override
	public List<Product> getAllByCategory(int categoryId) {
		
		Category category = null;
		Optional<Category> opt = categoryDAO.findById(categoryId);
		if(opt.isEmpty()) {
			throw new ResourceNotFoundException("Category", "Category Id", categoryId);
		}
		
		category = opt.get();
		List<Product> products = productDAO.findAllByCategoryCategoryId(categoryId);
		
		return products;
		
		
	}
	
	

}
