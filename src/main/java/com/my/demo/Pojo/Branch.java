package com.my.demo.Pojo;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="branch")
public class Branch {
	@Id
	@GeneratedValue
	@Expose
	private Long Branchid;
	@ManyToOne
	@JoinColumn(name="bankid")
	private Bank bank;
	@OneToMany(mappedBy="branch",fetch=FetchType.EAGER)
	private  List<LoanType> loantypeList;
	@OneToOne(mappedBy="branch")
	private Manager manager;
	
	@Expose
	private String branchname;
	@Expose
	private String branchaddress;
	@Expose
	private String ifsccode;
	
	
	
	public Branch() {
		super();
	}
	public Long getBranchid() {
		return Branchid;
	}
	public void setBranchid(Long branchid) {
		Branchid = branchid;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getBranchaddress() {
		return branchaddress;
	}
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	public String getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}
	public List<LoanType> getLoantype() {
		return loantypeList;
	}
	public void setLoantype( List<LoanType> loantype) {
		this.loantypeList = loantype;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public void addloantypeList(LoanType e) {
		this.loantypeList.add(e);
	}
	@Override
	public String toString() {
		return "Branch [Branchid=" + Branchid + ", loantypeList=" + loantypeList + ", manager=" + manager
				+ ", branchname=" + branchname + ", branchaddress=" + branchaddress + ", ifsccode=" + ifsccode + "]";
	}


}
