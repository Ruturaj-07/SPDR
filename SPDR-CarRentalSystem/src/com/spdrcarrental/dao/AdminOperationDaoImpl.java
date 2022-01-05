package com.spdrcarrental.dao;

//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.spdrcarrental.bean.Car;
import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.factory.ConnectionFactory;

public class AdminOperationDaoImpl implements AdminOperationDao {

	@Override
	public String addCar(Car car) {
		// TODO Auto-generated method stub
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();

			int rowcount=stmt.executeUpdate("insert into cardetails values ("+car.getCarid()+",' "+car.getCarmodel()+" ',' "+car.getNo_plate()+" ',"+car.getCapacity()+","+car.getMileage()+","+car.getPrice_per_day()+");");
			if(rowcount==1)
				status="\nCar Added Successfully..";
			else
				status="\nCar Added Uncessfull...";


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			status="\nCar Registration Failed Due to Wrong Connection..";
			e.printStackTrace();
		}
		return status;


	}

	@Override
	public String deleteCar(int Carid) {
		// TODO Auto-generated method stub

		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();

			int row=stmt.executeUpdate("delete from cardetails where carid=' "+Carid+" ' ");
			if(row==1) {
				status="\nCar deleted succesfully";
			}else {
				status="\nCar not deleted";
			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			status="\nCar Deletion Unsccessfull Due to Wrong Connection..";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String updateCar(int id,int price) {
		// TODO Auto-generated method stub
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from cardetails where carid=' "+id+" ' ");

			Boolean b=rs.next();
			if(b==true) {

				int rowcount=stmt.executeUpdate("update cardetails set priceperday = "+price+" where carid="+id+" ");
				if(rowcount==1)
					status="\nCar Updated Successfull..";
				else
					status="\nCar Updation Unsccessfull..";
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			status="\nCar Updation Unsccessfull Due to Wrong Connection..";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteCustomer(int custid) {
		// TODO Auto-generated method stub
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();

			stmt.executeUpdate("delete from rentdetails where custid=' "+custid+" ' ");
			int row=stmt.executeUpdate("delete from customer where custid=' "+custid+" ' ");
			if(row==1) {
				status="\nCustomer record  deleted succesfully. !!";
			}else {
				status="\nCustomer Record Not Found.";
			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			status="\nCustomer Deletetion Unsccessfull Due to Wrong Connection......";
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public void viewCustomer() {
		// TODO Auto-generated method stub

		try {
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select custid,cname,Phoneno,email,Address from customer ");
			System.out.println("Custid\t\tCname\t\t\tPhoneNo\t\t\t    Email\t\t\tAddress");
			while(rs.next()) {

				System.out.println(rs.getInt(1)+"\t\t "+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t "+rs.getString(4)+" \t\t"+rs.getString(5));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());

		}
	}



}


