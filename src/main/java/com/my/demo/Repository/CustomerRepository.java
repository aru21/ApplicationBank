package com.my.demo.Repository;

import javax.persistence.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.my.demo.Pojo.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>   {
	
	
}
