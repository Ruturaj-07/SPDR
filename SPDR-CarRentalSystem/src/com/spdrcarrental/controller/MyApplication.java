package com.spdrcarrental.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.spdrcarrental.bean.Car;
import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.bean.Rent;
import com.spdrcarrental.dao.CarDAOImpl;
import com.spdrcarrental.factory.CarDAOFactory;
import com.spdrcarrental.factory.CustomerRegistrationFactory;
import com.spdrcarrental.service.CustomerRegistrationService;
import com.spdrcarrental.service.RegistrationImplementation;

public class MyApplication {

	public void homepage(){

		Scanner sc=new Scanner(System.in);
		CustomerRegistrationService crs1=CustomerRegistrationFactory.getRegistration();
		CustomerRegistrationService mycar=CustomerRegistrationFactory.getRegistration();
		CarDAOImpl myCarDao=CarDAOFactory.getCarDAOImpl();
		AdminLogin m=new AdminLogin();
		CustomerReg cr1=new CustomerReg();
		CustLogin cl=new CustLogin();
		Customer cust=new Customer();

		int ch;
		System.out.println("***********************************Welcome To SPDR Car Rental System******************************************");


		do
		{

			System.out.println("\n1.User login");
			System.out.println("2.Registration");
			System.out.println("3.Admin login\n0.Exit");

			System.out.println("\nEnter your choice : ");

			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				cl.custlogin(cust);
				break;

			case 2:

				String message=cr1.customerReg();
				System.out.println(message);
				break;

			case 3:

				m.adminOperation();
				break;

			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("\nYou have entered the wrong choice !!!!!!!");

			}//outer switch
		}while(ch!=0);
	}

	public static void main(String[] args)throws Exception {
		try {
			MyApplication myap=new MyApplication();
			try (Scanner sc = new Scanner(System.in)) {
				int ch;
				System.out.println("\n\n1.Enter to Car Rental System ");
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					myap.homepage();
					break;
					//				case 2:
					//					System.exit(0);
					//					break;
				default:
					System.out.println("\nYou have Entered the wrong Choice ");

				}
			}
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("\nWrong Input...Please Enter The correct Input");
			//e.printStackTrace();
		}
		catch (Exception e1) {
			// TODO: handle exception
			System.out.println(e1.getMessage());
		}

		//int op=sc.nextInt();
	}//main
}//class end






