package com.obapp.usecases;

import java.util.Scanner;

import com.obapp.dao.AccountantDao;
import com.obapp.dao.AccountantDaoImpl;
import com.obapp.exceptions.AccountantException;

public class UpdateCustomer {
	
	public static void updateCust() {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("\nEnter the Field you want to change : \n");
		System.out.println("1 - Name");
		System.out.println("2 - City");
		System.out.println("3 - Mobile Number");
		System.out.println("4 - Email");
		System.out.println("5 - D.O.B.");
		System.out.println("6 - PIN\n");
		System.out.print("Enter your choice : ");
		
		int choice = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter the A/c. No. : ");
		int acnumber = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter the new value : ");
		String value = sc.nextLine();  
		
		AccountantDao dao = new AccountantDaoImpl();
		
		try {
			
			String result = dao.updateCustomer(choice, value, acnumber);
			System.out.println(result);
			
		} catch (AccountantException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		System.out.println("\n====================================");
		
	}

	/*
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Field you want to change : ");
		System.out.println("1. Name");
		System.out.println("2. City");
		System.out.println("3. Mobile Number");
		System.out.println("4. Email");
		System.out.println("5. D.O.B.");
		System.out.println("6. PIN");
		
		int choice = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter the new value : ");
		String value = sc.nextLine();  
		
		System.out.println("Enter the A/c. No. : ");
		int acnumber = sc.nextInt();
		
		AccountantDao dao = new AccountantDaoImpl();
		
		try {
			
			String result = dao.updateCustomer(choice, value, acnumber);
			System.out.println(result);
			
		} catch (AccountantException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}

	}
	*/

}
