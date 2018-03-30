package com.pavan.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pavan.manager.CategoryManager;
import com.pavan.manager.StockManager;
import com.pavan.manager.UserManager;
import com.pavan.model.Category;
import com.pavan.model.Stock;
import com.pavan.model.User;

public class Many2ManyTest {
	
	public static void main(String[] args) {
		
	
	
		System.out.println("Hibernate many to many Annotation");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		CategoryManager CategoryManager = (CategoryManager)ctx.getBean("categoryManagerImpl");
		StockManager stockManager = (StockManager)ctx.getBean("stockManagerImpl");
		
		
		Stock stock = new Stock();
        stock.setStockCode("7053");
        stock.setStockName("PADIN1");
 
        Category category1 = new Category("CONSUME1", "CONSUMER COMPAN1");
        Category category2 = new Category("INVESTMEN1", "INVESTMENT COMPAN1");
    
        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);
        
        stock.setCategories(categories);
        
        stockManager.insertStock(stock);
        
        /*

*CREATE TABLE `stock` (
  `STOCK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(10) NOT NULL,
  `STOCK_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
)



stockCREATE TABLE `category` (
  `CATEGORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(10) NOT NULL,
  `DESC` varchar(255) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`) USING BTREE
)


CREATE TABLE  `stock_category` (
  `STOCK_ID` int(10) unsigned NOT NULL,
  `CATEGORY_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`STOCK_ID`,`CATEGORY_ID`),
  CONSTRAINT `FK_CATEGORY_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`),
  CONSTRAINT `FK_STOCK_ID` FOREIGN KEY (`STOCK_ID`) REFERENCES `stock` (`STOCK_ID`)
)

*/

	    
	}

}
