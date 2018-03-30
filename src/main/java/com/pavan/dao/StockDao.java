package com.pavan.dao;

import java.util.List;

import com.pavan.model.Stock;

public interface StockDao {
	
	void insertStock(Stock stock);

	List<Stock> findAllStock();

}
