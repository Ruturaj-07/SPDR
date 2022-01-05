//package com.spdrcarrental.dao;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import com.spdrcarrental.bean.Customer;
//import com.spdrcarrental.factory.ConnectionFactory;
//
//public class CustomerLoginDaoImpl implements CustomerLoginDao {
//	Customer cust=null;
//	@Override
//	public Customer search(String username, String password) {
//		
//		// TODO Auto-generated method stub
//		try {
//			Connection con=ConnectionFactory.getConnection();
//			Statement stmt=con.createStatement();
//			ResultSet rs=stmt.executeQuery("Select * FROM customer WHERE Username=' "+username+" ' and Password=' "+password+" ' ");
//
//
//			Boolean b=rs.next();
//			if(b==true) {
//				cust.setCustId(rs.getInt(1));
//				cust.setCname(rs.getString("Cname"));
//				cust.setAddress(rs.getString("Address"));
//				cust.setEmail(rs.getString("Email"));
//				cust.setPhoneNo(rs.getString("PhoneNo"));
//				cust.setUsername(rs.getString("Username"));
//				cust.setPassword(rs.getString("Password"));
//			}else {
//				cust=null;
//			}//else
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//catch
//
//		return cust;
//	}//method
//}//class
