package com.obapp.usecases;

import java.sql.Date;
import java.util.Scanner;

import com.obapp.dao.AccountantDao;
import com.obapp.dao.AccountantDaoImpl;
import com.obapp.exceptions.AccountantException;
import com.obapp.model.Customer;

public class AddCustomer {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter City : ");
		String city = sc.next();
		
		System.out.println("Enter Mobile No. : ");
		String mobile_no = sc.next();
		
		System.out.println("Enter Email : ");
		String email = sc.next();
		
		System.out.println("Enter DOB (yyyy-mm-dd) format : ");
		String d = sc.next();
		Date dob = Date.valueOf(d);
		
		System.out.println("Enter PIN : ");
		int pin = sc.nextInt();
		
		System.out.println("Enter Balance : ");
		int balance = sc.nextInt();
		
		Customer customer = new Customer();
		
		customer.setName(name);
		customer.setCity(city);
		customer.setMobile_no(mobile_no);
		customer.setEmail(email);
		customer.setDob(dob);
		customer.setPin(pin);
		customer.setBalance(balance);
		
		AccountantDao dao = new AccountantDaoImpl();
		
		try {
			
			String result = dao.addCustomer(customer);
			System.out.println(result);
			
		} catch (AccountantException e) {
			
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}

	}

}
