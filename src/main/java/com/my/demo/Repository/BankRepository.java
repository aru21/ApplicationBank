package com.my.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my.demo.Pojo.Bank;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long>{

}
