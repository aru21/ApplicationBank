package com.my.demo.Dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.demo.Pojo.Customer;
import com.my.demo.Pojo.LoanApplication;

@Repository
public class CustomerDao 
{
	@Autowired
	EntityManager entityManager;
	@Transactional
	public void saveCustomer(Customer customer) 
	{
		System.err.println("inside dao");
		/*"insert into customer c c.firstname= : ,c.lastname= ,c.mobileno= :,c.email= :,c.password= :,c.address= :,c.birthdate= : ,c.gender=:"*/
		Query query = entityManager.createNativeQuery("insert into customer(firstname ,lastname ,mobileno ,email ,password ,address ,birthdate ,gender) values(?,?,?,?,?,?,?,?)");
	
		query.setParameter(1, customer.getFirstname());
		query.setParameter(2,customer.getLastname() );
		query.setParameter(3, customer.getMobileno());
		query.setParameter(4, customer.getEmail());
		query.setParameter(5, customer.getPassword());
		query.setParameter(6, customer.getAddress());
		query.setParameter(7, customer.getBirthdate());
		query.setParameter(8, customer.getGender());
	
		int no = query.executeUpdate();
		System.out.println(no);
	}
	
	@Transactional
	public Customer checkLogin(Customer customer) {
	/*	Query query = entityManager.createNativeQuery("select * from customer where email = ? and password = ?");
		query.setParameter(1, customer.getEmail());
		query.setParameter(2, customer.getPassword());*/
		try
		{
		Query query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.email = :email and c.password= :password").setParameter("email", customer.getEmail()).setParameter("password", customer.getPassword());
		
		customer = (Customer) query.getSingleResult();
		System.out.println(customer);
		}
		catch (Exception e) {
			return null;
		}
		return customer;
	}
}
