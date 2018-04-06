package com.my.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my.demo.Pojo.LoanApplication;

@Repository
public interface LoanApplicationRepository extends CrudRepository<LoanApplication, Long>{

}
