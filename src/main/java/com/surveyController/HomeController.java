package com.surveyController;




import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.Customer;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String root(){
		return "index";
	}
	
	@RequestMapping("/register")
	public ModelAndView register(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register");
		mv.addObject("customer", new Customer());
		return mv;
	}	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "index";
	}

}
