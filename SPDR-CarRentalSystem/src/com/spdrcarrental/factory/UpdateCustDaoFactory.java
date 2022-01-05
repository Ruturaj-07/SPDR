package com.spdrcarrental.factory;

import com.spdrcarrental.dao.CustomerRegistrationDAO;
import com.spdrcarrental.dao.UpdateCustDataImpl;

public class UpdateCustDaoFactory {
	private static UpdateCustDataImpl updatecustdao;
	static {
		updatecustdao=new UpdateCustDataImpl();
	}
	public static UpdateCustDataImpl getUpdateCustdao() {
		return updatecustdao;
	}
}
