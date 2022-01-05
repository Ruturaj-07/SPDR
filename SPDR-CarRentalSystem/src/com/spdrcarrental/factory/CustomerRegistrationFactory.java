package com.spdrcarrental.factory;
import com.spdrcarrental.dao.CustomerRegistrationDAO;
import com.spdrcarrental.service.CustomerRegistrationService;
import com.spdrcarrental.service.RegistrationImplementation;

public class CustomerRegistrationFactory {

	private static CustomerRegistrationService crs;

	static {
		crs=new RegistrationImplementation();
	}

	public static CustomerRegistrationService getRegistration() {
		return crs;	
	}

}
