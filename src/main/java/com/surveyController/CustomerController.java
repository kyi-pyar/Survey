package com.surveyController;



import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.Entity.Customer;
import com.Entity.Role;
import com.Exception.SurveyException;
import com.surveyDao.CustomerDao;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/savecutomer")	
	public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, HttpSession session){
			
		
		if(result.hasErrors()){
			return "register";
		};
		
		Customer cc=customerDao.getEmail(customer.getEmail());
		System.out.println(cc);
		
		if(cc==null){
		Customer c=customerDao.saveCustomer(customer);
		session.setAttribute("user", c);
		}
		else{			
		 throw new SurveyException("email already exists");
		}
		return "index";
	}
	
	@RequestMapping("/profile")
	public String profile(){
		return "profile";
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping(value="/checkuser",method=RequestMethod.POST)
	public String checklogin(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session){
		//System.out.println("login: "+name+":"+password);
		Customer c=customerDao.getCustomer(name, password);
		if(c==null){
			/*session.setAttribute("login", "not-match");
			return "login";*/
			throw new SurveyException("user name and password does not match");
		}
		else{
			session.removeAttribute("login");
			session.setAttribute("user", c);
			return "index";
		}
		
	}
	@RequestMapping("/manage_user")
	public ModelAndView getUser(){
		List<Customer> aa=customerDao.getAllCustomer();
		//for(Customer c:customers)System.out.println(c);			
		ModelAndView mv=new ModelAndView();
		mv.setViewName("all_user");
		mv.addObject("customers", aa);
		return mv;
				
	}
	
	@RequestMapping("/promote_customer")
	public ModelAndView promoteCustomer(@RequestParam("cid") int cid){
		//System.out.println("customer id to promote"+cid);
		customerDao.promoteCustomer(cid);
		List<Customer> aa=customerDao.getAllCustomer();				
		ModelAndView mv=new ModelAndView();
		mv.setViewName("all_user");
		mv.addObject("customers", aa);
		return mv;
	}
	@RequestMapping("/delete_customer")
	public ModelAndView deleteCustomer(@RequestParam("cid") int cid){
		//System.out.println("customer id to promote"+cid);
		customerDao.deleteCustomer(cid);
		List<Customer> aa=customerDao.getAllCustomer();				
		ModelAndView mv=new ModelAndView();
		mv.setViewName("all_user");
		mv.addObject("customers", aa);
		return mv;
	}
}
