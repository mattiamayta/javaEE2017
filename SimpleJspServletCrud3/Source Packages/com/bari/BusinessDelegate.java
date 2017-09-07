package com.bari;

import java.util.List;

import com.bari.dao.BusinessService;
import com.bari.model.User;

public class BusinessDelegate {
	private BusinessLookup lookupService = new BusinessLookup();
	private BusinessService businessService;
	private String serviceType;

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void checkUser(User user) {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.checkUser(user);
	}

	public void addUser(User user) {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.checkUser(user);
	}

	public void deleteUser(String userId) {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.deleteUser(userId);
	}

	public void updateUser(User user) {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.updateUser(user);
	}

	public List<User> getAllUsers() {
		businessService = lookupService.getBusinessService(serviceType);
		return businessService.getAllUsers();
	}

	public User getUserById(String userId) {
		businessService = lookupService.getBusinessService(serviceType);
		return businessService.getUserById(userId);
	}
}
