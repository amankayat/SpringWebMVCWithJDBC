package com.example.springwebmvcexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springwebmvcexample.dto.CustomerDTO;
import com.example.springwebmvcexample.exceptions.CustomerNotFoundException;
import com.example.springwebmvcexample.model.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private CustomerDTO custDto;

	public CustomerDTO getCustomerById(Integer custId) throws CustomerNotFoundException {
		//From DB you may get null values then throw exception
		if (custDto.getCustId()==null && custDto.getCustName()==null) {
			custDto.setCustId(15);
			custDto.setCustName("BlueYonder");
		} else {
			throw new CustomerNotFoundException();
		}
		return custDto;
	}
	public CustomerDTO getCustomerByName(String custName) throws CustomerNotFoundException{
		if (custName!=null) {
			custDto.setCustId(10);
			custDto.setCustName(custName);
		} else {
			throw new CustomerNotFoundException();
		}
		return custDto;
	}
	@Override
	public boolean deleteCustomerById(Integer custId) throws CustomerNotFoundException {
		if(custId!=null)
			return true;
		
		return false;
	}
	@Override
	public boolean createCustomer(CustomerDTO customerdto) {
		if(customerdto!=null)
			return true;
		return false;
	}

}


