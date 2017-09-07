package com.bari.dao;

import java.util.List;

import com.bari.model.*;

//questa è l'interfaccia comune ai due servizi
public interface BusinessService {
	void checkUser(User user);

	void addUser(User user);

	void deleteUser(String userId);

	void updateUser(User user);

	List<User> getAllUsers();

	User getUserById(String userId);

}
