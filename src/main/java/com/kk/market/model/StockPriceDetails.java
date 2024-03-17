package com.kk.market.model;

import java.util.List;

public class StockPriceDetails {
	
	private String symbol;
	
	private List<StockPrice> stockPriceList;

	public List<StockPrice> getStockPriceList() {
		return stockPriceList;
	}

	public void setStockPriceList(List<StockPrice> stockPriceList) {
		this.stockPriceList = stockPriceList;
	}
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


}
