package com.pavan.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavan.dao.StockDao;
import com.pavan.manager.StockManager;
import com.pavan.model.Stock;

@Service
public class StockManagerImpl implements StockManager {

	@Autowired
	private StockDao stockDao;
	
	
	@Transactional
	public void insertStock(Stock stock) {
		stockDao.insertStock(stock);
	}

	@Transactional
	public List<Stock> findAllStocks() {
		return stockDao.findAllStock();
	}
	
	@Transactional
	public List<Stock> findStockData(Integer answerId) {
		return stockDao.findStockData(answerId);
	}

}
