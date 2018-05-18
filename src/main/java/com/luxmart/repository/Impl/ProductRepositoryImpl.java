package com.luxmart.repository.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luxmart.model.Product;
import com.luxmart.repository.ProductRepository;

@Repository("productRepository")
@Transactional 
public class ProductRepositoryImpl  implements ProductRepository{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	// get the product by Id
	@Override
	public Product getProduct(long id) {

       Session session = sessionFactory.getCurrentSession();
		
		return (Product) session.get(Product.class, id);
	
	}

	// find how to get the inner join or the values form one to many in hibernate
	// get a list of products
	@Override
	public List<Product> listProducts() {
		Session session = sessionFactory.getCurrentSession();
	//	Query query = session.createQuery("FROM Product as prod Inner Join Author as author on prod.productId = author.productId");
		Query query = session.createQuery("FROM Product");
		
		@SuppressWarnings("unchecked")
		List<Product> productList = query.list();
		
		return productList;
	}

	
	
}
