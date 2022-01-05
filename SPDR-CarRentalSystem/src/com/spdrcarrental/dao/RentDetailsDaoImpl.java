package com.spdrcarrental.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.spdrcarrental.bean.Rent;
import com.spdrcarrental.factory.ConnectionFactory;

public class RentDetailsDaoImpl implements RentDetailsDao {

	@Override
	public void bookCar(Rent rent) {
		// TODO Auto-generated method stub
		Random random=new Random();

		try {
			//int i=0;
			double amount=0;
			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();
			int amt=0;
			int rday=0;
			int rid=0;
			int rowcount=stmt.executeUpdate("insert into rentdetails(custid,carid,orderdate,returndate,amount) values ("+rent.getCustId()+",' "+rent.getCarid()+" ',' "+rent.getOrderdate()+" ',' "+rent.getReturndate()+" ',"+amt+")");

			PreparedStatement ps=con.prepareStatement("select * from rentdetails ");
			ResultSet rs1=ps.executeQuery();
			int r1=0;

			while(rs1.next()) {
				r1=rs1.getInt(6);
				rid=rs1.getInt(1);

			}
			System.out.println("\nYour order id : "+rid);

			PreparedStatement ps1=con.prepareStatement("select * from cardetails ");
			ResultSet rs2=ps1.executeQuery();
			int priceperday=0;

			while(rs2.next()) {
				priceperday=rs2.getInt(6);
			}
			//System.out.println("price per day="+priceperday);

			amount=r1*priceperday;
			//System.out.println("amount :"+amount);


			int rowcount1=stmt.executeUpdate("update  rentdetails set amount="+amount+" where rid="+rid+" ");

			if(rowcount1==1)
				System.out.println("\nOrder Purchased Successfully.....\nTHANK YOU For Your Puchase from SPDR car Rental System....have a Great Day...!!"); 
			else
				System.out.println("\nOrder not placed");
			
			int billno=random.nextInt(10000);
			String query="insert into billingInfo values("+billno+","+rent.getCustId()+","+rent.getCarid()+","+amount+")";
			int row=stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("\nYou have Enterd the wrong Details..");
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}


	}

}
