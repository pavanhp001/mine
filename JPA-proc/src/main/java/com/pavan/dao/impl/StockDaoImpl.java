package com.pavan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.stereotype.Repository;

import com.pavan.dao.StockDao;
import com.pavan.model.Category;
import com.pavan.model.Stock;
/*import com.pavan.model.Category_;
import com.pavan.model.Stock_;
*/
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
	  
	  public List<Stock> findStockData(Integer answerId){
		  
		  //http://www.thejavageek.com/2014/04/28/criteria-api-joins/
		  
		  CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Stock> criteriaQuery = criteriaBuilder.createQuery(Stock.class);
	        Root<Category> categoryRoot = criteriaQuery.from(Category.class);
	        //SetJoin<Category, Stock> answers = stockRoot.join(Stock_.categories);
	        Join<Category, Stock> answers = categoryRoot.join("stocks");
	       // SetJoin<Category, Stock> answers = answerRoot.join(answerRoot.get("stocks"));
	       // SetJoin<Category, Stock> answers = answerRoot.join(answerRoot.get("stocks"));
	        CriteriaQuery<Stock> cq = criteriaQuery.select(answers);
	        cq.where(criteriaBuilder.equal(categoryRoot.get("categoryId"),answerId));
	        TypedQuery<Stock> query = entityManager.createQuery(cq);
	        return query.getResultList();
	  }
	  
	  /*CriteriaBuilder cb = em.getCriteriaBuilder();
	  CriteriaQuery<Phone> query = cb.createQuery(Phone.class);
	  Root<Teacher> teacher = query.from(Teacher.class);
	  Join<Teacher, Phone> phones = teacher.join("phones");
	  query.select(phones).where(cb.equal(teacher.get("firstName"), "prasad"));*/

}
