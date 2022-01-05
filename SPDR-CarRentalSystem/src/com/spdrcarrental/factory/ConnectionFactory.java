package com.spdrcarrental.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con;
	static {
		
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Miniproject","root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	public static Connection getConnection() {
		return con;
	}

}
