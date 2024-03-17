package com.kk.market.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSX");
		
		StockPrice stockPrice = new StockPrice();
		stockPrice.setDate(sdf.parse("2024-03-01T00:00:00.0000+00:00"));
		
		stockPrice.setClose(1234.78);
		stockPrice.setHigh(1255.88);
		stockPrice.setOpen(1234.77);
		stockPrice.setLow(1231.99);
		stockPrice.setVolume(3452432D);
		
		
		StockPrice stockPrice1 = new StockPrice();
		stockPrice1.setDate(sdf.parse("2024-03-02T00:00:00.0000+00:00"));
		
		stockPrice1.setClose(1234.78);
		stockPrice1.setHigh(1255.88);
		stockPrice1.setOpen(1234.77);
		stockPrice1.setLow(1231.99);
		stockPrice1.setVolume(3452432D);
		
		stockpriceDetails.setStockPriceList(Arrays.asList(stockPrice,stockPrice1));
		stockpriceDetails.setSymbol(symbol);

		return stockpriceDetails;
	}

}
