package com.my.demo.Pojo;

import java.util.Set;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="loantype")
public class LoanType {
	@Id
	@GeneratedValue
	@Expose
	private Long loantypeid;
	
	@ManyToOne
	@JoinColumn(name="branchid")
	private Branch branch;
	
	@OneToMany(mappedBy="loantype")
	private Set <LoanApplication> loanapplication;
	
	
	@Expose
	private String loantypename;
	
	@Expose
	private Float intrestrate;
	
	
	public Long getLoantypeid() {
		return loantypeid;
	}
	public void setLoantypeid(Long loantypeid) {
		this.loantypeid = loantypeid;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public String getLoantypename() {
		return loantypename;
	}
	public void setLoantypename(String loantypename) {
		this.loantypename = loantypename;
	}
	public Float getIntrestrate() {
		return intrestrate;
	}
	public void setIntrestrate(Float intrestrate) {
		this.intrestrate = intrestrate;
	}
	public Set<LoanApplication> getLoanapplication() {
		return loanapplication;
	}
	public void setLoanapplication(Set<LoanApplication> loanapplication) {
		this.loanapplication = loanapplication;
	}
	@Override
	public String toString() {
		return "LoanType [loantypeid=" + loantypeid + ", loanapplication=" + loanapplication + ", loantypename="
				+ loantypename + ", intrestrate=" + intrestrate + "]";
	}
	
	

}
