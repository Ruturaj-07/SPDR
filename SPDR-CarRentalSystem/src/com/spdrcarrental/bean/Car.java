package com.spdrcarrental.bean;

public class Car extends Customer {
	private int carid;
	private String carmodel;
	private String no_plate;
	private int capacity;
	private int mileage;
	private int price_per_day;
	
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getNo_plate() {
		return no_plate;
	}
	public void setNo_plate(String no_plate) {
		this.no_plate = no_plate;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getPrice_per_day() {
		return price_per_day;
	}
	public void setPrice_per_day(int price_per_day) {
		this.price_per_day = price_per_day;
	}
	@Override
	public String toString() {
		return "Car [carid=" + carid + ", carmodel=" + carmodel + ", no_plate=" + no_plate + ", capacity=" + capacity
				+ ", mileage=" + mileage + ", price_per_day=" + price_per_day + "]";
	}
	
}
