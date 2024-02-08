package com.example.springwebmvcexample.utility;

import com.example.springwebmvcexample.dto.CustomerDTO;
import com.example.springwebmvcexample.exceptions.CustomerNotFoundException;
import com.example.springwebmvcexample.model.Customer;

public class CustomerUtility {
 
	public static Customer convertcustomerDTOtocustomer(CustomerDTO custDTO) 	{
		Customer customer = new Customer();
		customer.setCustId(custDTO.getCustId());
		customer.setCustName(custDTO.getCustName());
		
		return customer;
	}
	public static CustomerDTO convertcustomertocustomerdto(Customer customer)  {
		CustomerDTO customerdto = new CustomerDTO();
		customerdto.setCustId(customer.getCustId());
		customerdto.setCustName(customer.getCustName());
		return customerdto;
	}
}
