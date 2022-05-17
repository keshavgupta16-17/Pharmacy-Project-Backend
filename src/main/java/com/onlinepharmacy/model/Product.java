package com.onlinepharmacy.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ProductJPA")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ProductJPA_productId_seq")
	@Column(name = "ProductId")
	private int productId;
	
	@Column(name = "ProductName")
	private String productName;
	
	@Column(name = "Manufacturer")
	private String manufacturer;
	
	@Column(name = "Price")
	private double price;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "CategoryId")
	@JsonIgnoreProperties("products")
	private Category category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, String manufacturer, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String brand) {
		this.manufacturer = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", manufacturer=" + manufacturer + ", price="
				+ price + "]";
	}
	
	

}
