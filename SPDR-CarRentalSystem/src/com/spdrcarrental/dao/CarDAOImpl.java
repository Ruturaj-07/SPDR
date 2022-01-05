package com.spdrcarrental.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.spdrcarrental.bean.Car;
import com.spdrcarrental.factory.ConnectionFactory;

public class CarDAOImpl implements CarDAO {
	ArrayList<Car> cars= new ArrayList<Car>();
	Car car1=new Car();
	//Car mycar[]=new Car[5];
	
	@Override
	public void showCarDetails(Car car) 
	{

		try {
			int i=0;

			Connection con=ConnectionFactory.getConnection();
			Statement stmt=con.createStatement();
			String sql="select * from cardetails;";
			ResultSet rs=stmt.executeQuery(sql);
			int rowcount=0;
			System.out.println("CARID\t\tCARMODEL\t NOPLATE\t\t\t CAPACITY \t\tMILEAGE\t\t\tPRICEPERDAY");

			while (rs.next()) {

				car1.setCarid(rs.getInt(1));
				car1.setCarmodel(rs.getString(2));
				car1.setNo_plate(rs.getString(3));
				car1.setCapacity(rs.getInt(4));
				car1.setMileage(rs.getInt(5));
				car1.setPrice_per_day(rs.getInt(6));

				System.out.println(car1.getCarid()+"\t\t"+car1.getCarmodel()+"\t\t"+car1.getNo_plate()+"\t\t\t  "+car1.getCapacity()+"\t\t\t"+car1.getMileage()+"\t\t\t"+car1.getPrice_per_day());

			}
			rs.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
