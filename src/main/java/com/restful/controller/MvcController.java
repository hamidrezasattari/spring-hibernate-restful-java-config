package com.restful.controller;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restful.service.CustomersService;
 
@RestController
public class MvcController {
    @Autowired
    private CustomersService  service;
    
	
	
	@RequestMapping("/serviceOne")
	public List<String> serviceOne( ) {//REST Endpoint 1.
		return service.findCustomersForServiceOne();
	}	
	
	@RequestMapping("/serviceTwo")
	public List<String> serviceTwo( ) {//REST Endpoint 2.
		return service.findCustomersForServiceTwo();
	}	

	
}
