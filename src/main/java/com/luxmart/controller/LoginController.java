package com.luxmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luxmart.comands.LoginCommand;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(Model model){
		
		model.addAttribute("loginCommand", new LoginCommand());
		
		return "loginform";
	}
	
	
	@RequestMapping(value = "/logout-success")
	public String logout(){
		
		return "logout-success";
	}

	
	//@RequestMapping(value = "/dologin", method = RequestMethod.POST)
//	public String dologin(@Valid LoginCommand loginCommand, BindingResult bindingResult){
//		
//		if(bindingResult.hasErrors()){
//			
//			return "loginform";
//		}
//		
//		return "redirect:/index";
//	}
	
	
}
