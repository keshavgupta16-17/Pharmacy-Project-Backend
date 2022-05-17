package com.onlinepharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepharmacy.model.Product;
import com.onlinepharmacy.service.ProductService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"http://localhost:4200"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAll();
	}
	
	@GetMapping("/categories/{categoryId}/products")
	public List<Product> getAllByCategory(@PathVariable int categoryId) {
		return productService.getAllByCategory(categoryId);
	}
	
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getById(id);
	}
	
	@PostMapping("/categories/{categoryId}/products")
	public Product addProduct(@PathVariable int categoryId, @RequestBody Product product) {
		return productService.add(categoryId, product);
	}
	
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		product.setProductId(id);
		return productService.update(id, product);
	}
	
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.delete(id);
		
	}
	
	
	
	

}

