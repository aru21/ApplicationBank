package com.my.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.demo.Pojo.Bank;
import com.my.demo.Pojo.Branch;
import com.my.demo.Pojo.LoanType;

@Repository
public class LoanTypeDao {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<LoanType> loanTypeByBranchId(long id) 
	{
		List<LoanType> loanTypes = new ArrayList<>();
		
		Branch	branch = new Branch(id);
		loanTypes =  entityManager.createQuery("from LoanType l where l.branch= :id").setParameter("id", branch).getResultList();
		System.out.println("inside dao "+ loanTypes);
		return loanTypes;
	}
	
}
