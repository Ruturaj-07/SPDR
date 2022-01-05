package com.spdrcarrental.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.factory.CustomerRegistrationFactory;
import com.spdrcarrental.service.CustomerRegistrationService;

public class CustomerReg {

	MyApplication mp2=new MyApplication();
	String status="";
	
	public String customerReg() {
		try {
			Scanner sc = new Scanner(System.in);
			CustomerRegistrationService crs2=CustomerRegistrationFactory.getRegistration();

			System.out.println("\n******************Welcome to regestration page*********************\n");
			System.out.println();
			Customer c=new Customer();

			System.out.println("Enter ur id no: ");
			c.setCustId(sc.nextInt());
			System.out.println("\nEnter Customer Name : ");
			c.setCname(sc.next());
			System.out.println("\nEnter Customer Address : ");
			c.setAddress(sc.next());
			System.out.println("\nEnter Customer Email : ");
			c.setEmail(sc.next());
			System.out.println("\nEnter Customer Phone Number : ");
			c.setPhoneNo(sc.nextLong());
			System.out.println("\nEnter Customer Username : ");
			c.setUsername(sc.next());
			System.out.println("\nEnter Customer Password : ");
			c.setPassword(sc.next());
			status=crs2.add(c);	
			System.out.println(status);

		}

		catch (InputMismatchException e) {
			System.out.println("Enter valid data");
			// TODO: handle exception
		}
		
		finally {
			mp2.homepage();
			return status;
		}
	}
}


