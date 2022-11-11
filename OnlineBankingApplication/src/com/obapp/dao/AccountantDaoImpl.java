package com.obapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.obapp.exceptions.AccountantException;
import com.obapp.model.Customer;
import com.obapp.utility.DBUtil;

public class AccountantDaoImpl implements AccountantDao {

	@Override
	public String signInAccountant(String username, String password) throws AccountantException {
		
		// TODO Auto-generated method stub
		
		String message = "Invalid username or PIN...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from accountant where username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) 
				message = "Signed In Successfully!";
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
			
		}
		return message;
	}

	@Override
	public String addCustomer(Customer customer) throws AccountantException {
		
		// TODO Auto-generated method stub
		String message = "Customer Not Added...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps = conn.prepareStatement("insert into customer (name,city,mobile_no,email,dob,pin,balance) values(?,?,?,?,?,?,?)");
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getCity());
			ps.setString(3, customer.getMobile_no());
			ps.setString(4, customer.getEmail());
			ps.setDate(5, customer.getDob());
			ps.setInt(6, customer.getPin());
			ps.setInt(7, customer.getBalance());
			
			int x = ps.executeUpdate();
			
			if(x > 0) 
				message = "Customer Added Successfully...";
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
			
		}
		
		return message;
	}

	@Override
	public String updateCustomer(int choice, String value, int acnumber) throws AccountantException {
		
		
		// TODO Auto-generated method stub
		
		String message = "Customer Not Found";
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = null;
			
			switch(choice) {
			
		    case 1: ps = conn.prepareStatement("update customer set name = ? where acnumber = ?");
		            ps.setString(1, value);
		            ps.setInt(2, acnumber);
		            break;
		            
		    case 2: ps = conn.prepareStatement("update customer set city = ? where acnumber = ?");
                    ps.setString(1, value);
                    ps.setInt(2, acnumber);
		            break;
		            
		    case 3: ps = conn.prepareStatement("update customer set mobile_no = ? where acnumber = ?");
                    ps.setString(1, value);
                    ps.setInt(2, acnumber);
		            break;
		            
		    case 4: ps = conn.prepareStatement("update customer set email = ? where acnumber = ?");
                    ps.setString(1, value);
                    ps.setInt(2, acnumber);
		            break;
		            
		    case 5: ps = conn.prepareStatement("update customer set dob = ? where acnumber = ?");
		            Date dob = Date.valueOf(value);
		            ps.setDate(1, dob);
		            ps.setInt(2, acnumber);
		            break;
		            
		    case 6: ps = conn.prepareStatement("update customer set pin = ? where acnumber = ?");
		            int pin = Integer.parseInt(value);
                    ps.setInt(1, pin);
                    ps.setInt(2, acnumber);
                    break;
		            
		    default : message = "Wrong Choice...";
		
		}
			
			int x = ps.executeUpdate();
			
			if(x > 0)
				message = "Customer Details Updated";
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
			
		}
		
		return message;
	}

	@Override
	public String removeCustomer(int acnumber) throws AccountantException {
		
		// TODO Auto-generated method stub
		String message = "No Customer found with A/c. No. " + acnumber;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps1 = conn.prepareStatement("DELETE from transdetails where acnumber = ?");

			ps1.setInt(1, acnumber);
			
			int x1 = ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement("DELETE from customer where acnumber = ?");

			ps2.setInt(1, acnumber);
			
			int x2 = ps2.executeUpdate();
			
			if(x2 > 0) 
				message = "Customer Deleted Successfully";
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
			
		}
		
		return message;
	}

	@Override
	public Customer showCustomerAccount(int acnumber) throws AccountantException {
		
		// TODO Auto-generated method stub
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customer where acnumber = ?");
			
			ps.setInt(1, acnumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String name = rs.getString("name");
				String city = rs.getString("city");
				String mobile_no = rs.getString("mobile_no");
				String email = rs.getString("email");
				Date dob = rs.getDate("dob");
				int anumber = rs.getInt("acnumber");
				int pin = rs.getInt("pin");
				int balance = rs.getInt("balance");
				
				customer = new Customer(name, city, mobile_no, email, dob, anumber, pin, balance);
				
			}
			else 
				throw new AccountantException("No Customer found with A/c. No. " + acnumber);
				
		} catch (SQLException e) {
			
			// TODO: handle exception
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
			
		}
		
		return customer;
	}

	@Override
	public List<Customer> showAllCustomers() throws AccountantException {
		
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String name = rs.getString("name");
				String city = rs.getString("city");
				String mobile_no = rs.getString("mobile_no");
				String email = rs.getString("email");
				Date dob = rs.getDate("dob");
				int anumber = rs.getInt("acnumber");
				int pin = rs.getInt("pin");
				int balance = rs.getInt("balance");
				
				Customer customer = new Customer(name, city, mobile_no, email, dob, anumber, pin, balance);
				
				list.add(customer);
				
			}
			
			if(list.size() == 0)
				throw new AccountantException("No Customers Found");
			
		} catch (SQLException e) {
			
			// TODO: handle exception
			e.printStackTrace();
			throw new AccountantException(e.getMessage());
			
		}
		
		return list;
	}

}
