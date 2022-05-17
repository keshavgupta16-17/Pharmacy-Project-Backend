package com.onlinepharmacy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CategoryJPA")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "category_id_seq")
	@Column(name = "CategoryId")
	private Integer categoryId;
	
	@Column(name = "CategoryName")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	@OneToMany(mappedBy = "category")//, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("category")
	private List<Product> products;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer id, String name, String description) {
		super();
		this.categoryId = id;
		this.name = name;
		this.description = description;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer id) {
		this.categoryId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	

}

