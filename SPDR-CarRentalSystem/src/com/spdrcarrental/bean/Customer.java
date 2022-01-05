package com.spdrcarrental.bean;

public class Customer {
	private int CustId;
	private String Cname;
	private String Address;
	private String Email;
	private long PhoneNo;
	private String username;
	private String password;
	
	public int getCustId() {
		return CustId;
	}
	public void setCustId(int custId) {
		CustId = custId;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer [CustId=" + CustId + ", Cname=" + Cname + ", Address=" + Address + ", Email=" + Email
				+ ", PhoneNo=" + PhoneNo + ", username=" + username + ", password=" + password + "]";
	}	
}
