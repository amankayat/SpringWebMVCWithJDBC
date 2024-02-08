package com.example.springwebmvcexample.controoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springwebmvcexample.dto.CustomerDTO;
import com.example.springwebmvcexample.exceptions.CustomerNotFoundException;
import com.example.springwebmvcexample.model.Customer;
import com.example.springwebmvcexample.service.CustomerService;
import com.example.springwebmvcexample.utility.CustomerUtility;

@Controller
public class CustomerController {
	
	
	@Autowired
	private CustomerService custService;
	
	/**
	@GetMapping("/getcustomerbyid")
	public ModelAndView getCustomerById() {
		mv.addObject("", custService);
		return mv;
	}**/
//	
//	@GetMapping("/hello")
//	public ModelAndView getMessage() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("customerdetails");
//		return mv;
//	}
//	@RequestMapping(value="/greetings",method=RequestMethod.GET)
//	public ModelAndView greetings() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("greet");
//		return mv;
//	}
//	@RequestMapping(value="/greeting",method=RequestMethod.GET)
//	public ModelAndView greetings(@RequestParam(value="name")String name,@RequestParam(value="surname")String surname) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name",name);
//		mv.addObject("surname",surname);
//		mv.setViewName("greet");
//		return mv;
//	}
//	@RequestMapping(value="/message/{msg}",method=RequestMethod.GET)
//	public ModelAndView greetings(@PathVariable("msg")String message) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg",message);
//		
//		mv.setViewName("message");
//		return mv;
//	}
//	
	
	
	@GetMapping("/getcustomer")
	public ModelAndView getCustomerById(@RequestParam("id")Integer custId) {
		ModelAndView mv = new ModelAndView();
		Customer customer=null;
		CustomerDTO custdto;
		try {
			custdto = custService.getCustomerById(custId);
			 customer = CustomerUtility.convertcustomerDTOtocustomer(custdto);
			
			
			mv.addObject("customer",customer);
//			
			mv.setViewName("customerdetails");
		} catch (CustomerNotFoundException |EmptyResultDataAccessException e) {
			mv.addObject("msg","customer with "+custId+" doesn't exist.");
			mv.setViewName("error");
		}
		
		
		return mv;
	}
	@GetMapping("/getcustomerbyname")
	public ModelAndView getCustomerByName(@RequestParam("name")String custName) {
		ModelAndView mv = new ModelAndView();
		Customer customer=null;
		CustomerDTO custdto;
		try {
			custdto = custService.getCustomerByName(custName);
			 customer = CustomerUtility.convertcustomerDTOtocustomer(custdto);
			
			
			mv.addObject("customer",customer);
//			
			mv.setViewName("customerdetails");
		} catch (CustomerNotFoundException e) {
			mv.addObject("msg","customer with "+custName+" doesn't exist.");
			mv.setViewName("error");
		}
		
		
		return mv;
	}
//	@GetMapping("/deletecustomerbyid/{id}")
	@RequestMapping(value="/deletecustomerbyid/{id}",method=RequestMethod.GET)
	public ModelAndView deletecustomerbyid(@PathVariable("id") int custId) {
		ModelAndView mv = new ModelAndView();
		Customer customer=null;
		boolean c;
		try {
			c = custService.deleteCustomerById(custId);
			mv.addObject("id",custId);
			
			mv.setViewName("delete");
			
			
		
		} catch (CustomerNotFoundException e) {
			mv.addObject("msg","customer with "+custId+" doesn't exist.");
			mv.setViewName("error");
		}
		
		
		return mv;
	}
	
	@GetMapping("/customerform")
	public ModelAndView getcustomerform(@ModelAttribute Customer customer) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerform");
		return mv;
	}
	
	@PostMapping("/addcustomer")
	public ModelAndView addCustomer(@ModelAttribute Customer customer) {
		ModelAndView mv = new ModelAndView();
		CustomerDTO customerdto = CustomerUtility.convertcustomertocustomerdto(customer);
		boolean c = custService.createCustomer(customerdto);
		if(c) {
				mv.addObject("msg","customer added successfully..");
			
			mv.setViewName("customeradd");
		}else {
			mv.addObject("msg","unable to add customer.. ");
			mv.setViewName("error");
		}
		return mv;
	}
}