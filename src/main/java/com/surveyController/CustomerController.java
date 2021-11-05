package com.surveyController;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.Customer;
import com.Exception.SurveyException;
import com.surveyDao.CustomerDao;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao customerDao;
	
	//crud
	
	@Autowired
	ServletContext servletContext;
	
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
	
	@RequestMapping("/uploadPhoto")
	public String uploadPhoto(){
		return "uploadPhoto";
	}
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public String uploadFile(@RequestParam("photo") CommonsMultipartFile file, HttpSession session) throws IOException{
		String source=("resources"+File.separator+"img");	
		String path = servletContext.getRealPath("/") + source ;
		String fname=file.getOriginalFilename();
		String fullpath= path+ File.separator+ fname;
		System.out.println("full path: "+fullpath);		
		byte[] b=file.getBytes();
		BufferedOutputStream stream=new BufferedOutputStream( new FileOutputStream(new File(fullpath)));
		stream.write(b);
		stream.flush();
		stream.close();
		System.out.println("file wrote");
		Customer c=(Customer) session.getAttribute("user");
		customerDao.saveProfilePic(c.getId(), fname);		
		session.setAttribute("user",customerDao.getCustomer(c.getId()) );		
		return "redirect:profile";
		
	}
	
	@RequestMapping("/download_photo")
	public String download(HttpServletResponse response, @RequestParam("photo")String photo) throws IOException{
		PrintWriter writer=response.getWriter();
		String source="resources"+File.separator+"img";	
		String path = servletContext.getRealPath("/") + source ;
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=" + photo );
		System.out.println(path+photo);
		FileInputStream inputStream=new FileInputStream(path+File.separator+photo);
		int i;
		while((i=inputStream.read())!=-1){
			writer.write(i);
		}
		inputStream.close();
		writer.close();		
		return "profile";
	}
}
