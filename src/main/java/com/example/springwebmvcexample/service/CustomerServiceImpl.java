package com.example.springwebmvcexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springwebmvcexample.dao.CustomerDAO;
import com.example.springwebmvcexample.dao.CustomerDAOjdbcImpl;
import com.example.springwebmvcexample.dto.CustomerDTO;
import com.example.springwebmvcexample.exceptions.CustomerNotFoundException;
import com.example.springwebmvcexample.model.Customer;



@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO custDAO;
	@Autowired
	private CustomerDAOjdbcImpl custJDBCDAO;

	@Override
	public CustomerDTO getCustomerById(Integer custId) throws CustomerNotFoundException {

		return custDAO.getCustomerById(custId);
	}

	@Override
	public CustomerDTO getCustomerByName(String custName) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return custDAO.getCustomerByName(custName);
	}

	@Override
	public boolean deleteCustomerById(Integer custId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return custDAO.deleteCustomerById(custId);
	}

	@Override
	public boolean createCustomer(CustomerDTO customerdto) {
		// TODO Auto-generated method stub
		return custJDBCDAO.createCustomer(customerdto);
	}

}