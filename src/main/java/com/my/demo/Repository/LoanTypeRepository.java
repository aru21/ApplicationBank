package com.my.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my.demo.Pojo.LoanType;

@Repository
public interface LoanTypeRepository  extends CrudRepository<LoanType, Long>{

}
