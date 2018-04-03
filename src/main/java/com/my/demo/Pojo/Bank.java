package com.my.demo.Pojo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Bank")
public class Bank {
	@Id
	private Long bankid;
	@OneToMany(mappedBy="bank")
	private Set<Branch> branchList;
	
	private String bankname;

	public Long getBankid() {
		return bankid;
	}

	public void setBankid(Long bankid) {
		this.bankid = bankid;
	}

	public Set<Branch> getBranch() {
		return branchList;
	}

	public void setBranch(Set<Branch> branch) {
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
