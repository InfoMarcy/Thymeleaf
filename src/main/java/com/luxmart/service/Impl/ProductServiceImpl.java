package com.luxmart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxmart.model.Product;
import com.luxmart.repository.ProductRepository;
import com.luxmart.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired 
	ProductRepository productRepository;
	
	@Override
	public Product getProduct(long id) {
		
		return productRepository.getProduct(id);
	}

	@Override
	public List<Product> listProducts() {
		
		return productRepository.listProducts();
	}

}
