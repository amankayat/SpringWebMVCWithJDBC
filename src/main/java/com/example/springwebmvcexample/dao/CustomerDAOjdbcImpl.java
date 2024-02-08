package com.example.springwebmvcexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.springwebmvcexample.dto.CustomerDTO;
import com.example.springwebmvcexample.exceptions.CustomerNotFoundException;
import com.example.springwebmvcexample.model.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
@Component("customerJDBCDAO")
@Primary
public class CustomerDAOjdbcImpl implements CustomerDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public CustomerDTO getCustomerById(Integer custId) throws CustomerNotFoundException {
		
		String sql = "select * from customerdata where custid=?";
		Object[] parameters = {custId};
		CustomerDTO customerdto = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(CustomerDTO.class),parameters);
 		return customerdto;
	}

	@Override
	public CustomerDTO getCustomerByName(String custName) throws CustomerNotFoundException {
		String sql = "select * from customerdata where custname=?";
		Object[] parameters = {custName};
		CustomerDTO customerdto = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(CustomerDTO.class),parameters);

		return customerdto;
	}

	@Override
	public boolean deleteCustomerById(Integer custId) throws CustomerNotFoundException {
		String sql = "delete from customerdata where custId=?";
		int result = jdbcTemplate.update(sql,custId);
		if(result>0) {
			   System.out.println("Insert successfully.");
	            return true;
		}
		
		
		return false;
	}

	@Override
	public boolean createCustomer(CustomerDTO customerdto) {
		String sql = "insert into customerdata(custid,custname)"+"values(?,?)";
		int result = jdbcTemplate.update(sql,customerdto.getCustId(),customerdto.getCustName());
		if(result>0) {
			   System.out.println("Insert successfully.");
	            return true;
		}
		
		return false;
	}

}
