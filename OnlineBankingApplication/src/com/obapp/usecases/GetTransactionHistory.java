package com.obapp.usecases;

import java.util.List;
import java.util.Scanner;

import com.obapp.dao.CustomerDao;
import com.obapp.dao.CustomerDaoImpl;
import com.obapp.exceptions.CustomerException;
import com.obapp.model.TransHistory;

public class GetTransactionHistory {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your A/c no. : ");
		int acnumber = sc.nextInt();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			
			List<TransHistory> list = dao.getTransactionHistory(acnumber);
			
			System.out.println("----------------------------------------------------------");
			System.out.printf("%-20s%-16s%6s%16s\n", "Transaction ID", "Date", "Amount", "Type");
			
			list.forEach(s -> {
				
				System.out.printf("%-20d%-16s%6d%16s\n", s.getTnumber(), s.getDot(), s.getTransaction_amount(), s.getTransaction_type());
				
			});
			
		} catch (CustomerException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}

	}

}
