package com.spdrcarrental.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.spdrcarrental.bean.Car;
import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.bean.Rent;
import com.spdrcarrental.dao.CarDAOImpl;
import com.spdrcarrental.dao.CustomerBillingInfoImpl;
import com.spdrcarrental.factory.CarDAOFactory;
import com.spdrcarrental.factory.ConnectionFactory;
import com.spdrcarrental.factory.CustomerRegistrationFactory;
import com.spdrcarrental.service.CustomerRegistrationService;


public class CustLogin  {

	MyApplication mapp=new MyApplication();
	String status="";
	public void custlogin(Customer cust) {
		Car car1=new Car();
		//Customer cust=new Customer();
		CustomerRegistrationService mycar=CustomerRegistrationFactory.getRegistration();
		CarDAOImpl myCarDao1=CarDAOFactory.getCarDAOImpl();
		Scanner sc = new Scanner(System.in);
		MyApplication myap=new MyApplication();
		CustomerBillingInfoImpl cb=new CustomerBillingInfoImpl();



		System.out.print("\nEnter Username : ");
		cust.setUsername(sc.next());
		System.out.print("\nEnter Password : ");
		cust.setPassword(sc.next());


		//String status="";

		try {
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM customer WHERE username=' "+cust.getUsername()+" ' and password=' "+cust.getPassword()+" ' ");

			Boolean b=rs.next();
			if(b==true)
			{
				while (rs.next()) {
					cust.setCustId(rs.getInt(1));
					cust.setCname(rs.getString(2));
					cust.setAddress(rs.getString(3));
					cust.setEmail(rs.getString(4));
					cust.setPhoneNo(rs.getLong(5));
					cust.setUsername(rs.getString(6));
					cust.setPassword(rs.getString(7));


				}//while{

				System.out.println("\n\n*****************LOGIN SUCCESSFUL********************\n");
				do {


					System.out.println("\n1.Show Availbele Cars \n2.Book Car\n3.View My Billing\n4.Update My Data \n0.logout and Go TO home Page ");
					System.out.println("\nEnter ur choice");
					int op=sc.nextInt();


					switch(op)
					{
					case 1:

						System.out.println("\n*****************Availble Cars******************\n\n");
						myCarDao1.showCarDetails(car1);
						break;

					case 2:
						System.out.println("\nBook your drive with us by just providing info your id,carid, orderdate,return date...\nWe happy to serve you Thank You..\n");
						System.out.println("-----------------------------------------------------------------------------------------------------");
						Rent rent=new Rent();
						System.out.println("\nEnter Customer id : ");
						rent.setCustId(sc.nextInt());
						System.out.println("\nEnter Car id :");
						rent.setCarid(sc.nextInt());
						System.out.println("\nEnter order date in year/month/date format : ");
						String odate=sc.next();
						//LocalDate date=LocalDate.parse(odate);
						rent.setOrderdate(odate);
						//						System.out.println("Your Entered Date is : "+odate);

						System.out.println("\nEnter return date in year/month/date format : ");
						String rdate=sc.next();
						//LocalDate date1=LocalDate.parse(rdate);
						rent.setReturndate(rdate);
						//						System.out.println("Your Enterd Date is :"+rdate);
						//						
						mycar.bookCarService(rent);

						break;

					case 3:  

						System.out.println("\nEnter your cutomer id : ");
						cust.setCustId(sc.nextInt());
						System.out.println("\nShow my billing details : ");
						cb.showBilling(cust);

						break;

					case 4:
						System.out.println("\nUpdate cutomer(update my details");
						System.out.println("\nYou can modify your name ,address,EmialId,Phone No ,Password ");
						System.out.println("\nPress 1 to update ");
						int choice=sc.nextInt();
						if(choice==1)
						{
							System.out.println("\nEnter the New Name : ");
							cust.setCname(sc.next());
							System.out.println("\nEnter new Address : ");
							cust.setAddress(sc.next());
							System.out.println("\nEnter new EmailId : ");
							cust.setEmail(sc.next());
							System.out.println("\nEnter Your Phone NO : ");
							cust.setPhoneNo(sc.nextLong());
							System.out.println("\nEnter new Password : ");
							cust.setPassword(sc.next());
							String status4=mycar.updateCustData(cust);
							System.out.println(status4);
						}
						else {

							break;
						}
					case 0:
						mapp.homepage();
						//System.exit(0);
						break;
					default:
						System.out.println("\nEnter valid option..");
					}
				}while(true);


			}
			else {
				System.out.println("\nInvalid Username and Password...");
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			status="\nRegistration Unsccessfull Due to Wrong Connection..";
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
}