package com.luxmart.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luxmart.comands.CheckoutCommand;

@Controller
public class CheckoutController {
	
	
	@RequestMapping(value="checkout", method=RequestMethod.GET)
	public String Checkout(Model model){
		
		
		
		model.addAttribute("checkoutCommand", new CheckoutCommand());
		return "checkoutform";
	
	}
	
	@RequestMapping(value="docheckout", method=RequestMethod.POST)
	public String doCheckout(@Valid CheckoutCommand  checkoutCommand, BindingResult bindingResult ){
		
		
		if(bindingResult.hasErrors()) {
			return "checkoutform"; 
		}
		
		return "checkoutcomplete";
		
		
	}
	

}
