package com.spdrcarrental.service;
import java.util.ArrayList;

import com.spdrcarrental.bean.Car;
import com.spdrcarrental.bean.Customer;
import com.spdrcarrental.bean.Rent;

public interface CustomerRegistrationService {
	public String add(Customer customer);
	public void showCarService(Car car);
	public void bookCarService(Rent rent);
	public String addCarService(Car car);
	public String updateCar(int id,int price);
	public String deleteCar(int carid);
	public String deleteCustomer(int custid);
	public String updateCustData(Customer cust);
	public void viewCustomer();
	//public Customer loginCustomer(String username,String password);
}