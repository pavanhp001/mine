package com.pavan.O2O;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class O2ODao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional // should be there for insertion operation
	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	@Transactional // should be there for insertion operation
	public void insertDesk(Desk desk) {
		entityManager.persist(desk);
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
