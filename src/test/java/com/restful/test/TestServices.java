package com.restful.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.restful.configuration.Configurator;
import com.restful.model.Customers;
import com.restful.service.CustomersService;
 
/**
 * 
 *  this run integration tests (for two rest services) and also it calls  dao/service layers 
 *  methods so it fails  in case of methods failure.
 *  And unit test for add/delete customers
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Configurator.class })
@WebAppConfiguration
public class TestServices {

    private MockMvc mockMvc;
 
    @Autowired
    private CustomersService  service;
     
    @Autowired
    private WebApplicationContext webApplicationContext;
    

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testControllerServiceOne() throws Exception {
        mockMvc.perform(get("/serviceTwo")
             
        ).andExpect(status().isOk());
    }
    
    @Test
    public void testControllerServiceTwo() throws Exception {
        mockMvc.perform(get("/serviceOne")
        ).andExpect(status().isOk());
     }  
    @Test  
    public void testAddRemoveCustomer()throws Exception {
    	Customers customer =new Customers (); 
    	customer.setCustomerId(	ThreadLocalRandom.current().nextInt(1000 ,64000 ));
    	customer.setAddress("Address test");
    	customer.setCity("Toronto");
    	customer.setContactName("test name");
    	customer.setCountry("Canada");
    	customer.setCustomerName("test name");
    	customer.setPostalCode("Y9Y 9Y9");
    	service.presistCustomer(customer);
    	service.deleteCustomer(customer);
    	
    }
 
    
}
