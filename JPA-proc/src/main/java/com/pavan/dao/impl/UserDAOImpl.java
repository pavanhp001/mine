package com.pavan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.pavan.dao.UserDAO;
import com.pavan.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	 @PersistenceContext
	  private EntityManager entityManager;

	 // @Override
	  public void insertUser(User user) {
	    entityManager.persist(user);
	  }

	 // @Override
	  public List<User> findAllUsers() {
	    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<User> cq = builder.createQuery(User.class);
	    Root<User> root = cq.from(User.class);
	    cq.select(root);
	    System.out.println("Query = "+cq.toString());
	    return entityManager.createQuery(cq).getResultList();
	  }
}
