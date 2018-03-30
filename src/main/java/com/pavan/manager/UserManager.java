package com.pavan.manager;

import java.util.List;

import com.pavan.model.User;

public interface UserManager {
	
	  void insertUser(User user);

	  List<User> findAllUsers();

}
