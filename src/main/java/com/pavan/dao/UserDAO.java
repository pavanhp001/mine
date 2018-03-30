package com.pavan.dao;

import java.util.List;

import com.pavan.model.User;

public interface UserDAO {

	void insertUser(User user);

	List<User> findAllUsers();

}
