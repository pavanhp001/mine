package com.pavan.manager;

import java.util.List;

import com.pavan.model.Stock;

public interface StockManager {
	  void insertStock(Stock Stock);
	  List<Stock> findAllStocks();
	  List<Stock> findStockData(Integer answerId);
}
