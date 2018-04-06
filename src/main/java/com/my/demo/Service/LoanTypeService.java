package com.my.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.demo.Pojo.LoanType;
import com.my.demo.Repository.LoanTypeRepository;

@Service
public class LoanTypeService {
	@Autowired
	private LoanTypeRepository loanTypeRepository;
	
	public LoanType	findOne(Long id) {
		return loanTypeRepository.findOne(id);
	}
}
