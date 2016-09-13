package com.restful.dao;

import java.util.List;

import com.restful.model.Customers;

public interface CustomersDao {
	List<Customers> findCustomersCriteriaOne( );
	List<Customers> findCustomersCriteriaTwo( );

}
