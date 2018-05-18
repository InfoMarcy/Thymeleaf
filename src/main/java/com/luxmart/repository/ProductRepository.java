package com.luxmart.repository;

import java.util.List;

import com.luxmart.model.Product;

public interface ProductRepository {
	
	// get product by id
		Product getProduct(long id);
		
		// get the list of products
		List<Product> listProducts();

}
