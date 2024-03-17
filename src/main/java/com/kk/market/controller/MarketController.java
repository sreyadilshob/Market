package com.kk.market.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.market.entity.Market;
import com.kk.market.model.StockPriceDetails;
import com.kk.market.service.MarketService;

@RestController
@RequestMapping("/market")
public class MarketController {

	@Autowired
	MarketService marketService;

	@GetMapping("/data/symbol/{symbol}")
	Market getStockDetailsbySymbol(@PathVariable String symbol) {
		return marketService.getMarketBySymbol(symbol);
	}
	@GetMapping("/price/symbol/{symbol}")
	StockPriceDetails getStockPricesBySymbol(@PathVariable String symbol) throws ParseException {
		return marketService.getStockPricesBySymbol(symbol);
	}
	

}
