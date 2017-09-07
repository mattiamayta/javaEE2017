package com.bari;

import com.bari.dao.*;

public class BusinessLookup {
	public BusinessService getBusinessService(String serviceType) {
		switch (serviceType) {
		case "dao":
			System.out.println("Sei nel servizio dao");
			return new UserDao();
		default:
			return new UserDao();
		}
	}
}
