package com.my.demo.Pojo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="loanapplication")
public class LoanApplication {
	@Id
	private Long loanapplicationid;
		
	
	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="loantypeid")
	private LoanType loantype;
	
	
	private Double loanamount;
	private Double annualincome;
	private Long duration;
	
	
	
	
	
	public Long getLoanapplicationid() {
		return loanapplicationid;
	}
	public void setLoanapplicationid(Long loanapplicationid) {
		this.loanapplicationid = loanapplicationid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Double getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(Double loanamount) {
		this.loanamount = loanamount;
	}
	public Double getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(Double annualincome) {
		this.annualincome = annualincome;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public LoanType getLoantype() {
		return loantype;
	}
	public void setLoantype(LoanType loantype) {
		this.loantype = loantype;
	}
		
	
	
	
	

}
