package com.spdrcarrental.dao;

import com.spdrcarrental.bean.Customer;

public interface CustomerLoginDao {
	public Customer search(String username,String password);

}
