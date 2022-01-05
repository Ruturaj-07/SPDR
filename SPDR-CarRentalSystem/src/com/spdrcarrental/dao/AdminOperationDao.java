package com.spdrcarrental.dao;

import com.spdrcarrental.bean.Car;
import com.spdrcarrental.bean.Customer;

public interface AdminOperationDao {
	public String addCar(Car car);
	public String deleteCar(int Carid);
	public String updateCar(int id,int price);
	public String deleteCustomer(int custid);
	public void viewCustomer();
	

}
