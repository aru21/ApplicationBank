package com.my.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.demo.Pojo.Bank;
import com.my.demo.Pojo.Branch;

@Repository
public class BranchDao {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Branch> branchByBankId(long id) 
	{
		List<Branch> branchs = new ArrayList<>();
		
		Bank bank = new Bank(id);
		branchs =  entityManager.createQuery("from Branch b where b.bank= :id").setParameter("id", bank).getResultList();
		System.out.println("inside dao "+ branchs);
		return branchs;
	}
	
}
