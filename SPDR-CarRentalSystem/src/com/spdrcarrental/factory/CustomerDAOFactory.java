package com.spdrcarrental.factory;

import com.spdrcarrental.dao.CustomerRegistrationDAO;

public class CustomerDAOFactory {
	private static CustomerRegistrationDAO custdao;
	static {
		custdao=new CustomerRegistrationDAO();
	}
	public static CustomerRegistrationDAO getCustomerDao() {
		return custdao;
	}
}
