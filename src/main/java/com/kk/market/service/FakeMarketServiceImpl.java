package com.kk.market.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.kk.market.entity.Market;
import com.kk.market.model.StockPrice;
import com.kk.market.model.StockPriceDetails;

@Profile("mock")
@Service
public class FakeMarketServiceImpl implements MarketService {

	@Override
	public Market getMarketBySymbol(String symbol) {
		return null;
	}

	@Override
	public StockPriceDetails getStockPricesBySymbol(String symbol) throws ParseException {

		StockPriceDetails stockpriceDetails = new StockPriceDetails();
		
		StockPrice stockPrice = new StockPrice();
		stockPrice.setDate(LocalDate.parse("2024-04-30"));
		
		stockPrice.setClose(1234.78);
		stockPrice.setHigh(1255.88);
		stockPrice.setOpen(1234.77);
		stockPrice.setLow(1231.99);
		stockPrice.setVolume(3452432D);
		
		
		StockPrice stockPrice1 = new StockPrice();
		stockPrice1.setDate(LocalDate.parse("2024-04-29"));
		
		stockPrice1.setClose(1234.78);
		stockPrice1.setHigh(1255.88);
		stockPrice1.setOpen(1234.77);
		stockPrice1.setLow(1231.99);
		stockPrice1.setVolume(3452432D);
		
		StockPrice stockPrice2 = new StockPrice();
		stockPrice2.setDate(LocalDate.parse("2024-04-28"));
		
		stockPrice2.setClose(1234.78);
		stockPrice2.setHigh(1255.88);
		stockPrice2.setOpen(1234.77);
		stockPrice2.setLow(1231.99);
		stockPrice2.setVolume(3452432D);
		
		stockpriceDetails.setStockPriceList(Arrays.asList(stockPrice,stockPrice1,stockPrice2));
		stockpriceDetails.setSymbol(symbol);

		return stockpriceDetails;
	}

}
