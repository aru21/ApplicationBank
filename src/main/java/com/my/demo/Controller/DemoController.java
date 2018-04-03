package com.my.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.demo.Dao.CustomerDao;
import com.my.demo.Pojo.*;
import com.my.demo.Service.CustomerService;

@Controller
public class DemoController {
	@Autowired
	private CustomerService customerService;

	private CustomerDao  customerDao;
	
 	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	
	@RequestMapping("/customerregister")
	public String register (Model model)
	{
		model.addAttribute(new Customer());
		
		return "customer/customerregister";
	}
	
	@RequestMapping(value="/customerregister" ,method=RequestMethod.POST)
	public String saveCustomer(Model model , Customer customer){
	customerService.save(customer);
	model.addAttribute("login", "Successfully registered now login");
	return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String checkLogin(Model model){
		System.out.println("inside login get");
		model.addAttribute(new Customer());
		return "customer/login";
		
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String processLogin( Model model , Customer customer){
		System.out.println("***************************************************************");
		System.out.println("inside login post");
		System.out.println(customer);
		if(customer != null) {
			Customer customer2 = new Customer();
			customer2 = customerService.CheckLogin(customer);
			if(customer2 != null)
			{
				model.addAttribute("customer", customer2);
				return "customer/success";
			}
		}
		model.addAttribute("error", "Invalid Credentials");
		return "customer/login";
		
	}
	
}
