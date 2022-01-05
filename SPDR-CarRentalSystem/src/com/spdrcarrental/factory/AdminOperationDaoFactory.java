package com.spdrcarrental.factory;

import com.spdrcarrental.dao.AdminOperationDaoImpl;
import com.spdrcarrental.service.CustomerRegistrationService;
import com.spdrcarrental.service.RegistrationImplementation;

public class AdminOperationDaoFactory {
	private static AdminOperationDaoImpl admindo;

	static {
		admindo=new AdminOperationDaoImpl();
	}

	public static AdminOperationDaoImpl getAdminDaoImp() {
		return admindo;	
	}

}
