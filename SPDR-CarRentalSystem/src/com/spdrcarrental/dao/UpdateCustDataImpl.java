package com.spdrcarrental.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.factory.ConnectionFactory;

public class UpdateCustDataImpl implements UpdateCustDataDao {

	@Override
	public String updateData(Customer cust) {
		// TODO Auto-generated method stub
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			int row=st.executeUpdate("Update customer set  cname='"+cust.getCname()+"',address=' "+cust.getAddress()+" ',Email=' "+cust.getEmail()+" ',PhoneNo='"+cust.getPhoneNo()+" ',password=' "+cust.getPassword()+" ' where custid="+cust.getCustId()+"");
			if(row==1)
			{
				status="\nRecord Updated Succesfully..!!";
			}
			else {
				status="\nRecord not Updated....!!";
			}


		}catch (Exception e) {
			// TODO: handle exception
			status="\nRecord Upadtation Not performed Due to poor Connection....!!!";
		}
		return status;
	}

}
