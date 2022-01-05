package com.spdrcarrental.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.spdrcarrental.bean.Car;
import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.dao.CarDAOImpl;
import com.spdrcarrental.factory.CarDAOFactory;
import com.spdrcarrental.factory.ConnectionFactory;
import com.spdrcarrental.factory.CustomerRegistrationFactory;
import com.spdrcarrental.service.CustomerRegistrationService;
import com.spdrcarrental.service.RegistrationImplementation;
//import com.spdrcarrental.controller;
//import com.spdrcarrental.controller.Myapplcation;

public class AdminLogin {
	MyApplication m1=new MyApplication();
	Scanner sc = new Scanner(System.in);
	int choice;
	public void adminOperation() {
		{
			CarDAOImpl myCarDao=CarDAOFactory.getCarDAOImpl();
			CustomerRegistrationService mycar1=CustomerRegistrationFactory.getRegistration();
			RegistrationImplementation reg=new RegistrationImplementation();
			Car car=new Car();

			MyApplication myap=new MyApplication();

			System.out.println("\n****************Welcome to Admin Page*******************\n");
			System.out.print("\nEnter username : ");
			String username=sc.nextLine();

			System.out.print("\nEnter Password : ");
			String pass=sc.nextLine();

			try {
				if(username.equals("admin")&&pass.equals("admin123"))
				{
					//while (rs.next()) {	}//while{

					do {
						System.out.println("\n**********************Admin login Successful***********************\n");

						System.out.println("\n\n1.View cardetails\n2.Add new car\n3.Update car Details\n4.Delete car\n5.Delete Customer \n6.View Customer Details\n7.Go to homePage\n0.Exit");
						System.out.println("\nEnter your choice : ");
						choice=sc.nextInt();

						switch(choice)
						{
						case 1:
							System.out.println("\n***********Availble Cars***************\n");
							myCarDao.showCarDetails(car);
							break;

						case 2:
							System.out.println("\n\nAdd newcar : ");
							System.out.println("\nEnter CarId : ");
							car.setCarid(sc.nextInt());
							System.out.println("\nEnter Car model : ");
							car.setCarmodel(sc.next());
							System.out.println("\nEnter No plate : ");
							car.setNo_plate(sc.next());
							System.out.println("\nEnter Capacity : ");
							car.setCapacity(sc.nextInt());
							System.out.println("\nEnter milegae : ");
							car.setMileage(sc.nextInt());
							System.out.println("\nEnter price per day : ");
							car.setPrice_per_day(sc.nextInt());

							String msg1=mycar1.addCarService(car);
							System.out.println(msg1);
							break;

						case 3:
							System.out.println("\n********Welcome To Car Update Page*********");
							System.out.println("\n\nYou can only update the Price Perday of Car.. ");
							System.out.println("\nEnter the carid : ");

							car.setCarid(sc.nextInt());
							int id=car.getCarid();
							System.out.println("\nEnter the New Price per day For Car..");

							car.setPrice_per_day(sc.nextInt());
							int price=car.getPrice_per_day();

							String status1=mycar1.updateCar(id,price);
							System.out.println(status1);			
							break;

						case 4:
							System.out.println("\n******************Welcome to delete car Page******************\n");
							Car car1=new Car();
							System.out.println("\n\nEnter the Carid You Want to Delete : ");
							int id1=sc.nextInt();
							car1.setCarid(id1);
							int p=car1.getCarid();
							String status2=mycar1.deleteCar(p);
							System.out.println(status2);
							break;

						case 5:
							System.out.println("\n***********Welcome to delete customer service**************\n");
							Customer cust1=new Customer();
							System.out.println("\n\nEnter the Customer Id you Want to Delete : ");
							cust1.setCustId(sc.nextInt());
							//					int id2=sc.nextInt();
							//					cust1.setCustId(id2);
							System.out.println("\nIf you delete the customer id then all the record related to same id will also deleted.!!");
							System.out.println("\nPress 1 to Continue..");
							int p2=sc.nextInt();
							if(p2==1)
							{
								String status3=mycar1.deleteCustomer(cust1.getCustId());
								System.out.println(status3);
							}
							else {
								break;
							}
						case 6:
							System.out.println();
							reg.viewCustomer();
							break;
							


						case 7:
							myap.homepage();
							break;
						case 0:
							System.exit(1);

						default:
							System.out.println("Wrong choice !!!!!\nPlease enter the correct Choice  :");
						}//switch
					}while(choice!=0);//do-while
				}//if
				else 
				{
					System.out.println("Wrong Username Or password !!! please Enter the correct Username and Password  ");
				}
			}
			catch (InputMismatchException im) {
				System.out.println("Your Input are Not Correct .....Please Enter the valid Input");
				// TODO: handle exception
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
			finally {
				m1.homepage();
			}

		}

	}
}
