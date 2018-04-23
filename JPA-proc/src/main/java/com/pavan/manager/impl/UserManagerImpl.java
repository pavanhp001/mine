package com.pavan.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavan.dao.UserDAO;
import com.pavan.manager.UserManager;
import com.pavan.model.User;

@Service
public class UserManagerImpl implements UserManager {
	
	 @Autowired
	  private UserDAO userDAO;

	 // @Override
	  @Transactional
	  public void insertUser(User user) {
	    userDAO.insertUser(user);
	  }

	 // @Override
	  public List<User> findAllUsers() {
	    return userDAO.findAllUsers();
	  }

}
