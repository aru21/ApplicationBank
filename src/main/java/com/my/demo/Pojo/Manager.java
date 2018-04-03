package com.my.demo.Pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="manager")
public class Manager {
	@Id
	@GeneratedValue
	private Long managerid;
	@OneToMany(mappedBy="manager")
	private Set <Customer> customerList;
	@OneToOne 
	@JoinColumn(name="branchid")
	private Branch branch;
	
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String gender;
	private Date birthdate;
	private String password;
	private Long mobileno;
	
	public Manager(Long managerid) {
		this.managerid = managerid;
	}

	public Manager()
	{}
	
	public Long getManagerid() {
		return managerid;
	}
	
	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}
	public Set<Customer> getCustomer() {
		return customerList;
	}
	public void setCustomer(Set<Customer> customer) {
		this.customerList = customer;
	}
	
	
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public void addCustomer(Customer customer)
	{
		customerList.add(customer);
	}

}
