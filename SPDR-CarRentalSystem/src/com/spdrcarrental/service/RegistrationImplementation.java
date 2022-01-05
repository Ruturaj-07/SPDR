package com.spdrcarrental.service;
import java.util.ArrayList;

import com.spdrcarrental.bean.Car;
import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.bean.Rent;
import com.spdrcarrental.dao.AdminOperationDaoImpl;
import com.spdrcarrental.dao.CarDAOImpl;
import com.spdrcarrental.dao.CustomerRegistrationDAO;
import com.spdrcarrental.dao.CustomerRegistrationDAOI;
import com.spdrcarrental.dao.RentDetailsDaoImpl;
import com.spdrcarrental.dao.UpdateCustDataImpl;
import com.spdrcarrental.factory.AdminOperationDaoFactory;
import com.spdrcarrental.factory.CarDAOFactory;
import com.spdrcarrental.factory.CustomerDAOFactory;
import com.spdrcarrental.factory.CustomerRegistrationFactory;
import com.spdrcarrental.factory.RentDetailsDaoImplFactory;
import com.spdrcarrental.factory.UpdateCustDaoFactory;

public class RegistrationImplementation implements CustomerRegistrationService {
	AdminOperationDaoImpl admindaoserv=AdminOperationDaoFactory.getAdminDaoImp();

	@Override
	public String add(Customer customer) {
		// TODO Auto-generated method stub
		CustomerRegistrationDAO custdao=CustomerDAOFactory.getCustomerDao();
		String status=custdao.addCustomerDAO(customer);
		return status;
	}

	@Override
	public void showCarService(Car car) {
		// TODO Auto-generated method stub
		CarDAOImpl cardaoserv=CarDAOFactory.getCarDAOImpl();
		cardaoserv.showCarDetails(car);
	}

	@Override
	public void bookCarService(Rent rent) {
		// TODO Auto-generated method stub
		RentDetailsDaoImpl rentdaoserv= RentDetailsDaoImplFactory.getRentDetailsDaoImpl();
		rentdaoserv.bookCar(rent);	
	}

	@Override
	public String addCarService(Car car) {
		// TODO Auto-generated method stub
		AdminOperationDaoImpl addcarserv=AdminOperationDaoFactory.getAdminDaoImp();
		String status=addcarserv.addCar(car);
		return status;
	}

	@Override
	public String deleteCar(int carid) {
		// TODO Auto-generated method stub
		String status=admindaoserv.deleteCar(carid);
		return status;
	}

	@Override
	public String updateCar(int id,int price) {
		// TODO Auto-generated method stub
		String status=admindaoserv.updateCar(id,price);
		return status;
	}

	@Override
	public String deleteCustomer(int custid) {
		// TODO Auto-generated method stub
		String status=admindaoserv.deleteCustomer(custid);
		return status;
	}


	@Override
	public String updateCustData(Customer cust) {
		// TODO Auto-generated method stub
		UpdateCustDataImpl updatecust=UpdateCustDaoFactory.getUpdateCustdao();
		String status=updatecust.updateData(cust);
		return status;
	}

	@Override
	public void viewCustomer() {
		// TODO Auto-generated method stub
		AdminOperationDaoImpl addcarserv=AdminOperationDaoFactory.getAdminDaoImp();
		addcarserv.viewCustomer();

	}


}
