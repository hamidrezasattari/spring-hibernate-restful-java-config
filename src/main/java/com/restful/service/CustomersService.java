package com.restful.service;

import java.util.List;

import com.restful.model.Customers;

public interface CustomersService {
	List<String> findCustomersForServiceOne();
	List<String> findCustomersForServiceTwo();
	void presistCustomer(Customers customers);
	void deleteCustomer(Customers customers);

}
