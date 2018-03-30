package com.pavan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.pavan.dao.StockDao;
import com.pavan.model.Stock;
import com.pavan.model.User;

@Repository
public class StockDaoImpl implements StockDao {
	
	@PersistenceContext
	  private EntityManager entityManager;

	 // @Override
	  public void insertStock(Stock stock) {
	    entityManager.persist(stock);
	  }

	 // @Override
	  public List<Stock> findAllStock() {
	    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Stock> cq = builder.createQuery(Stock.class);
	    Root<Stock> stocks = cq.from(Stock.class);
	    cq.select(stocks);
	    System.out.println("Query = "+cq.toString());
	    return entityManager.createQuery(cq).getResultList();
	  }

}
