package com.luxmart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue	
	private long id;
	
	@Column(name="product_category")
	private String category;
	
	
	@ManyToOne
	@JoinColumn(name ="productId")
	private Product product;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	


}
