package com.spdrcarrental.factory;

import com.spdrcarrental.dao.CarDAOImpl;
import com.spdrcarrental.dao.RentDetailsDaoImpl;

public class RentDetailsDaoImplFactory {
	private static RentDetailsDaoImpl rentdao;
	static {
		rentdao=new RentDetailsDaoImpl();
	}
	public static RentDetailsDaoImpl getRentDetailsDaoImpl() {
		return rentdao;
	}
}
