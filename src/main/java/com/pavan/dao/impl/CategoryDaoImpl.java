package com.pavan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.pavan.dao.CategoryDao;
import com.pavan.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@PersistenceContext
	  private EntityManager entityManager;

	 // @Override
	  public void insertCategory(Category category) {
	    entityManager.persist(category);
	  }

	 // @Override
	  public List<Category> findAllCategory() {
	    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Category> cq = builder.createQuery(Category.class);
	    Root<Category> categories = cq.from(Category.class);
	    cq.select(categories);
	    System.out.println(" Category Query = "+cq.toString());
	    return entityManager.createQuery(cq).getResultList();
	  }

/*	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
