package com.my.demo.Service;

import org.apache.catalina.servlet4preview.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.demo.Pojo.LoanApplication;
import com.my.demo.Repository.LoanApplicationRepository;

@Service
public class LoanApplicationService {

	@Autowired
	private LoanApplicationRepository loanApplicationRepository;
	
	public LoanApplication save(LoanApplication application) {
			return loanApplicationRepository.save(application);
	}
	
	
}
