package com.my.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;
import com.my.demo.Dao.BranchDao;
import com.my.demo.Dao.CustomerDao;
import com.my.demo.Dao.LoanTypeDao;
import com.my.demo.Pojo.*;
import com.my.demo.Repository.BankRepository;
import com.my.demo.Repository.LoanApplicationRepository;
import com.my.demo.Service.CustomerService;
import com.my.demo.Service.LoanApplicationService;
import com.my.demo.Service.LoanTypeService;

@Controller
public class DemoController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private BankRepository BankRepository;
	
	@Autowired
	private CustomerDao  customerDao;
	
	@Autowired
	private BranchDao  branchDao;
	
	@Autowired
	private LoanTypeDao loanTypeDao;
	
	@Autowired
	private LoanTypeService loanTypeService;
	
	@Autowired
	private LoanApplicationRepository loanApplicationRepository;
	
	
	@Autowired
	private LoanApplicationService loanapplicationservice;
	
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
	public String processLogin( Model model , Customer customer , HttpSession session){
		System.out.println("***************************************************************");
		System.out.println("inside login post");
		System.out.println(customer);
		if(customer != null) {
			Customer customer2 = new Customer();
			customer2 = customerService.CheckLogin(customer);
			if(customer2 != null)
			{
				List<Bank> banks = new ArrayList<>();
				banks = (List<Bank>) BankRepository.findAll();
				model.addAttribute("listAllBank",banks);
				model.addAttribute("customer", customer2);
				model.addAttribute("loanApplication" , new LoanApplication());
				session.setAttribute("sessionCustomer", customer2);
				return "customer/success";
			}
		}
		model.addAttribute("error", "Invalid Credentials");
		return "customer/login";
		
	}
	
	@RequestMapping(value="loadAllBranch/{id}" , method= RequestMethod.GET)
	@ResponseBody
	public String loadState(@PathVariable("id") Long id)
	{
		System.out.println(id + "id by controller");
		System.out.println(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(branchDao.branchByBankId(id)));
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(branchDao.branchByBankId(id));
		
	}
	
	
	@RequestMapping(value="loadAllLoanType/{id}" , method= RequestMethod.GET)
	@ResponseBody
	public String loadAllLoanType(@PathVariable("id") Long id)
	{
		System.out.println(id + "id by controller");
		System.out.println("///////////////////////////////////////////////////////////////////////////////");
		System.out.println(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(loanTypeDao.loanTypeByBranchId(id)));
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(loanTypeDao.loanTypeByBranchId(id));
		
	}
	
	@RequestMapping(value = "/confirmLoan"  , method = RequestMethod.POST)
	public String afterSuccess(Model model , LoanApplication loanApplication ,HttpSession session){
		Long id = (Long) session.getAttribute("loanType");
		Customer customer = (Customer) session.getAttribute("sessionCustomer");
		
		LoanType loanType = loanTypeService.findOne(id);
		loanApplication.setLoantype(loanType);
		loanApplication.setCustomer(customer);
		//loanapplicationservice.save(loanApplication);
		session.setAttribute("loanApplicationPojo", loanApplication);
		model.addAttribute("confirmLoanObject", loanApplication);
		return "customer/confirmLoan";
		
	}
	
	
	@RequestMapping(value="test/{id}" , method= RequestMethod.GET)
	@ResponseBody
	public void test(@PathVariable("id") Long id , HttpSession session)
	{
		
		session.setAttribute("loanType", id);
		System.out.println(id + "id by controller/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*/*//*/*/*/*/**/***/");
		
		
	}
	
	@RequestMapping(value = "/customerLoan"  , method = RequestMethod.POST)
	public String customerLoan(Model model , LoanApplication loanApplication ,HttpSession session , @RequestParam String action ){
		loanApplication = (LoanApplication) session.getAttribute("loanApplicationPojo");
		model.addAttribute("customer",session.getAttribute("sessionCustomer"));
		List<Bank> banks = (List<Bank>) BankRepository.findAll();
		model.addAttribute("listAllBank" , banks);
		model.addAttribute("loanApplication", loanApplication);
		if(action.equals("Submit"))
		{
			
			System.out.println("submit" + loanApplication);
			loanapplicationservice.save(loanApplication);
			return "customer/listAllAppliedLoan";
		}
		System.out.println("Cancel");
		return "customer/success";
	}
	
	
}
