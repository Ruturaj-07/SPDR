package com.spdrcarrental.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.factory.ConnectionFactory;


public class CustomerRegistrationDAO implements CustomerRegistrationDAOI {

	@Override
	public String addCustomerDAO(Customer customer) {
		// TODO Auto-generated method stub
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from customer where  CustId=' "+customer.getCustId()+" ' ");
			
			Boolean b=rs.next();
			if(b==true)
				status="\nCustomer Already Registered..";
			else {
				int rowcount=stmt.executeUpdate("insert into customer values('"+customer.getCustId()+" ',' "+customer.getCname()+" ',' "+customer.getAddress()+" ',' "+customer.getEmail()+" ',' "+customer.getPhoneNo()+" ',' "+customer.getUsername()+" ',' "+customer.getPassword()+" ')");
				if(rowcount==1)
					status="\nRegistration Successfull..";
				else
					status="\nRegistration Unsccessfull..";
			}
				
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			status="\nRegistration Unsccessfull Due to Wrong Connection..";
			//e.printStackTrace();
		}
		return status;
	}
	
}
