package com.my.demo.Pojo;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Bank")
public class Bank {
	@Id
	@GeneratedValue
	private Long bankid;
	@OneToMany(mappedBy="bank")
	private List<Branch> branchList;
	
	private String bankname;

	
	
	public Bank() {
	}

	public Bank(long id) {
		this.bankid = id;
	}

	public Long getBankid() {
		return bankid;
	}

	public void setBankid(Long bankid) {
		this.bankid = bankid;
	}

	public List<Branch> getBranch() {
		return branchList;
	}

	public void setBranch(List<Branch> branch) {
		this.branchList = branch;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	public void addBranch(Branch branch) {
		branchList.add(branch);
	}
	
	

}
