package com.example.springwebmvcexample.dao;

import com.example.springwebmvcexample.dto.CustomerDTO;
import com.example.springwebmvcexample.exceptions.CustomerNotFoundException;
import com.example.springwebmvcexample.model.Customer;

public interface CustomerDAO {
	
	public CustomerDTO getCustomerById(Integer custId) throws CustomerNotFoundException;
	public CustomerDTO getCustomerByName(String custName) throws CustomerNotFoundException;
public boolean deleteCustomerById(Integer custId)throws CustomerNotFoundException;
public boolean createCustomer(CustomerDTO customerdto);
}