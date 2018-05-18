package com.luxmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String home(){
		
		// return "redirect:/index";
		return "redirect:/index";
	}
	

	
	
	@RequestMapping("/ajax")
	public String index(){
			
		// tutorial JSON and AJAX Tutorial: With Real Examples
	   // https://www.youtube.com/watch?v=rJesac0_Ftw
			return "index";
		}
	
	
	@RequestMapping("/handlebar")
	public String handerbar(){
		
		    // tutorial Handlebars.js Tutorial (webpack integration at the end)
			// https://www.youtube.com/watch?v=wSNa5b1mS5Y
			return "handlebar";
		}
	
	
}