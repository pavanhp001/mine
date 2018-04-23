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
        stock.setStockCode("7055");
        stock.setStockName("PADIN3");
 
        Category category1 = new Category("CONSUME2", "CONSUMER COMPAN2");
        Category category2 = new Category("INVESTMEN2", "INVESTMENT COMPAN2");
        Category category3 = new Category("INVESTMEN3", "INVESTMENT COMPAN3");
        Category category4 = new Category("INVESTMEN4", "INVESTMENT COMPAN4");
        Category category5 = new Category("INVESTMEN5", "INVESTMENT COMPAN5");
    
        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        
        stock.setCategories(categories);
        
      //  stockManager.insertStock(stock);
        
        //System.out.println("Inserted Stock details successfully ...");
        
        Category category11 = new Category("CONSUME22", "CONSUMER COMPAN22");
        
        Set<Stock> stocks = new HashSet<Stock>();
        
        Stock stock1 = new Stock("1000","mobile1");
        Stock stock2 = new Stock("1001","mobile2");
        Stock stock3 = new Stock("1002","mobile3");
        Stock stock4 = new Stock("1003","mobile4");
        Stock stock5 = new Stock("1004","mobile5");
        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        stocks.add(stock4);
        stocks.add(stock5);
        
        category11.setStocks(stocks);
        
       // CategoryManager.insertCategory(category11);
       // System.out.println("Inserted Category details successfully ...");
        
        List<Stock> stacks = stockManager.findAllStocks();
        
        for(Stock stockdata : stacks){
        	System.out.println("stockdata : "+stockdata.getStockCode()+" - "+ stockdata.getStockName()+" - "+stockdata.getStockId());
        	if(stockdata.getCategories() != null){
        		/*Set<Category> categorySet = stockdata.getCategories();
        		for(Category categoryData : categorySet){
        			
        			System.out.println("categoryData : "+categoryData.getCategoryId()+" - "+categoryData.getName()+" - ");
        			
        		}*/
        	}
        }
        
       /* List<Stock> stacksListData = stockManager.findStockData(5); // Cotogiry_Id = 5
        
        for(Stock stockdata : stacksListData){
        	System.out.println("stockdata : "+stockdata.getStockCode()+" - "+ stockdata.getStockName()+" - "+stockdata.getStockId());
        	if(stockdata.getCategories() != null){
        		Set<Category> categorySet = stockdata.getCategories();
        		for(Category categoryData : categorySet){
        			
        			System.out.println("categoryData : "+categoryData.getCategoryId()+" - "+categoryData.getName()+" - ");
        			
        		}
        		
        	}
        }*/
        
        /*

*
CREATE TABLE `stock` (
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
