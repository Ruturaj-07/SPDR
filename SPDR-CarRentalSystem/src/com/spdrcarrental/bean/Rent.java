package com.spdrcarrental.bean;

public class Rent extends Car {
	private int Rid;
	private int  CustId;
	private int carid;
	private String orderdate;
	private String returndate;
	private int rday;
	private double amount;
	public int getRid() {
		return Rid;
	}
	public void setRid(int rid) {
		Rid = rid;
	}
	public int getCustId() {
		return CustId;
	}
	public void setCustId(int custId) {
		CustId = custId;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String date) {
		this.orderdate = date;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public int getRday() {
		return rday;
	}
	public void setRday(int rday) {
		this.rday = rday;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Rent [Rid=" + Rid + ", CustId=" + CustId + ", carid=" + carid + ", orderdate=" + orderdate + ", returndate="
				+ returndate + ", rday=" + rday + ", amount=" + amount + "]";
	} 




}
