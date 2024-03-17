package com.kk.market.service;

import java.text.ParseException;

import com.kk.market.entity.Market;
import com.kk.market.model.StockPriceDetails;

public interface MarketService {


	Market getMarketBySymbol(String symbol);

	StockPriceDetails getStockPricesBySymbol(String symbol) throws ParseException;

}
