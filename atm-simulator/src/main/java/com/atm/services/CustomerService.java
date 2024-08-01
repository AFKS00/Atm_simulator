package com.atm.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.entities.Customer;
import com.atm.repositorie.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository custRepoRef;
	
	//insert one Customer details
	public void insertAtmDetails(Customer atmDetail)
	{
		custRepoRef.save(atmDetail);
	}
	
	//insert Array of Customer details
	public void insertArrayOfAtmDetails(List<Customer> atmDetail)
	{
		custRepoRef.saveAll(atmDetail);
	}
	
	//Show All Customer
	public List<Customer> atmDetails()
	{
		return custRepoRef.findAll();
	}
		
	//show Customer by id
	public Customer findAtmById(int id)
	{
		List<Customer> ls = custRepoRef.findAll();
		Customer foundAtm = null;
		for(Customer a : ls)
		{
			if(id==a.getCustId())
			{
				foundAtm = a;
				break;
			}
		}
		return foundAtm;
	}
	
	
	public void deleteAtmById(int id)
	{
		List<Customer> ls = custRepoRef.findAll();
		for(Customer a : ls)
		{
			if(a.getCustId() == id)
			{
				custRepoRef.delete(a);
			}
		}
	}
	
	public void updateAtm(Customer updateAtm)
	{
		List<Customer> ls = custRepoRef.findAll();
		for(Customer a : ls)
		{
			if(updateAtm.getCustId() == a.getCustId())
			{
				custRepoRef.save(updateAtm);
				
			}
		}
	}
	
	public void updateArrayAtm(List<Customer> listAtmDetails)
	{
		List<Customer> ls = custRepoRef.findAll();
		for(Customer a : ls)
		{
		for(Customer b : listAtmDetails)
		{
			if(a.getCustId() == b.getCustId())
			{
				custRepoRef.save(b);
			}
		}
	}
	}

}
