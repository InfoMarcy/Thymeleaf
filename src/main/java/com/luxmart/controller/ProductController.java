package com.luxmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luxmart.service.ProductService;

@Controller
public class ProductController {
	
	// get the product from db
	private ProductService  productService;
	
	@Autowired
	public void setProductService(ProductService  productService){
		this.productService = productService;
	}
	
	// index page of the product
	@RequestMapping("/index")
	public String getIndex(Model model){
		
	
		//List<Product> product = productService.listProducts();
		
	model.addAttribute("products", productService.listProducts());
		
//		for(Product item : product){
//			
//			System.out.println(item.getAuthor().get(0).getFirstName());
//		}
	
//	System.out.println(product);
		return "home";		
		
	}
	
	// if product don't have an id redirect them to the home page
	@RequestMapping("/product")
	public String sendHome(){
			
			return "redirect:/index";
		}
	

	// get the product by id
	@RequestMapping("/product/{id}")
	public String getProduct(@PathVariable(value= "id", required=false) long id, Model model){
		
		
		
		model.addAttribute("product", productService.getProduct(id));
			
			return "product";
		}

	
	// secure with thymeleaf security
	@RequestMapping("/secured")
	public String securedContent(){
			
			return "securedContent";
		}
	
	
	
	
}
