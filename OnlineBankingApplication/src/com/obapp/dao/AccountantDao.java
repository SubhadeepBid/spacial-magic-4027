package com.obapp.dao;

import java.util.List;

import com.obapp.exceptions.AccountantException;
import com.obapp.model.Customer;

public interface AccountantDao {
	
	public String signInAccountant(String username, String password) throws AccountantException;
	
	public String addCustomer(Customer customer) throws AccountantException;
	
	public String updateCustomer(int choice, String value, int acnumber) throws AccountantException;
	
	public String removeCustomer(int acnumber) throws AccountantException;
	
	public Customer showCustomerAccount(int acnumber) throws AccountantException;
	
	public List<Customer> showAllCustomers() throws AccountantException;

}
