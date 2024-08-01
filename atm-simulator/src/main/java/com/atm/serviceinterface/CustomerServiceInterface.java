package com.atm.serviceinterface;
import java.util.List;

import org.springframework.stereotype.Service;

import com.atm.entities.Customer;

@Service
public interface CustomerServiceInterface {
	
    public void insertCustomerDetails(Customer CustomerDetail);
    public void insertArrayOfCustomerDetails(List<Customer> CustomerDetail);
    public List<Customer> CustomerDetails();
    public Customer findCustomerById(int id);
    public Customer findCustomerByName(String name);
    public void deleteCustomerById(int id);
    public void updateCustomer(Customer updateCustomer);
    public void updateArrayCustomer(List<Customer> listCustomerDetails);

}
