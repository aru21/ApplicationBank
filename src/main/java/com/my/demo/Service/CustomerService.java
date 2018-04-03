package com.my.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.demo.Repository.CustomerRepository;
import com.my.demo.Dao.CustomerDao;
import com.my.demo.Pojo.Customer;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerDao customerDao;
	public void save(Customer customer)
	{
		System.out.println("inside service");
		customerRepository.save(customer);
	}
	
	public Customer CheckLogin(Customer customer)
	{
		System.out.println("inside service CheckLogin");
		return customerDao.checkLogin(customer);
	}
	

}
