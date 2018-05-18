package com.luxmart.service;

import java.util.List;

import com.luxmart.model.Product;

public interface ProductService {
	// get product by id
	Product getProduct(long id);
	
	// get the list of products
	List<Product> listProducts();

}
