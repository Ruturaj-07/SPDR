package com.spdrcarrental.factory;
import com.spdrcarrental.dao.CarDAOImpl;

public class CarDAOFactory {
	private static CarDAOImpl cardao;
	static {
		cardao=new CarDAOImpl();
	}
	public static CarDAOImpl getCarDAOImpl() {
		return cardao;
	}
}
