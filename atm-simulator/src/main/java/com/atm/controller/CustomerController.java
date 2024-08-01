package com.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.atm.entities.Customer;
import com.atm.serviceinterface.CustomerServiceInterface;


public class CustomerController {
	@Autowired
	private CustomerServiceInterface CustomerServiceRef;
	
	@GetMapping("/GetCustomer")
	public List<Customer> getAllCustomer()
	{
		return CustomerServiceRef.CustomerDetails();
	}
	
	@PostMapping("/InsertCustomer/details")
	public void insertDetails(@RequestBody Customer details)
	{
		CustomerServiceRef.insertCustomerDetails(details);
		System.out.println("Inserted Successful" + details);
	}
	
	@PostMapping("/InsertCustomer/CustomerDetails")
	public void insertArrayOfCustomerDetails(@RequestBody List<Customer> CustomerDetails)
	{
		CustomerServiceRef.insertArrayOfCustomerDetails(CustomerDetails);
		System.out.println("Inserted records successfully.");
	}
	
	@GetMapping("/GetCustomer/{id}")
	public Customer findCustomerById(@PathVariable int id)
	{
		return CustomerServiceRef.findCustomerById(id);
	}
	
	@GetMapping("/GetCustomer/{name}")
	public Customer findCustomerByName(@PathVariable String name)
	{
		return CustomerServiceRef.findCustomerByName(name);
	}
	
	@PostMapping("/DeleteCustomer/{id}")
	public void deleteCustomerById(@PathVariable int id)
	{
		CustomerServiceRef.deleteCustomerById(id);
	}
	
	@PostMapping("/UpdateCustomer/CustomerDetails")
	public void updateCustomer(@RequestBody Customer CustomerDetail)
	{
		CustomerServiceRef.updateCustomer(CustomerDetail);
	}
	
	@PostMapping("/UpdatearrayCustomer/listCustomerDetails")
	public void updateArrayCustomer(@RequestBody List<Customer> listCustomerDetail)
	{
		CustomerServiceRef.updateArrayCustomer(listCustomerDetail);
	}

}
