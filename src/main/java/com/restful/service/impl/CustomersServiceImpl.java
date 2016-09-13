package com.restful.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restful.dao.impl.CustomersDaoImpl;
import com.restful.model.Customers;
import com.restful.service.CustomersService;

@Service("customersService")
@Transactional
public class CustomersServiceImpl implements CustomersService {
	@Autowired
	private CustomersDaoImpl dao;

	public List<String> findCustomersForServiceOne() {

		List<Customers> customers = dao.findCustomersCriteriaOne();
		return customers.stream().map(x -> x.getCustomerName()).collect(Collectors.toList());
	}

	public List<String> findCustomersForServiceTwo() {

		List<Object[]> rows = dao.findCustomersCriteriaTwo();
		return rows.stream().map(objects -> (String) objects[2]).collect(Collectors.toList());
	}

 	public void presistCustomer(Customers customers) {
		dao.persist(customers);
		
	}
 	public void deleteCustomer(Customers customers) {
		dao.delete(customers);
		
	} 	

}
