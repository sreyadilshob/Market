package com.kk.market.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kk.market.entity.Market;
import com.kk.market.exception.ServiceNotavailableException;
import com.kk.market.model.Price;
import com.kk.market.model.StockPrice;
import com.kk.market.model.StockPriceDetails;
import com.kk.market.model.TimeSeries;

@Profile("dev")
@Service
public class MarketServiceImpl implements MarketService {
	@Autowired
	RestTemplate restTemplate;

	@Value("${url.market.api}")
	String marketkApiUrl;

	@Value("${url.timeseries.api}")
	String timeSeriesApiUrl;

	@Value("${url.market.apikey}")
	String apiKey;

	@Override
	public Market getMarketBySymbol(String symbol) {
		ResponseEntity<Market> response = restTemplate.getForEntity(marketkApiUrl, Market.class, symbol, apiKey);

		if (response.getStatusCode().is2xxSuccessful()) {
			System.out.println("Response status is successful");
			System.out.println(response.getBody());
		}
		Market market = response.getBody();

		return market;
	}

	@Override
	public StockPriceDetails getStockPricesBySymbol(String symbol) throws ParseException {
		ResponseEntity<TimeSeries> response = restTemplate.getForEntity(timeSeriesApiUrl, TimeSeries.class, symbol,	apiKey);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSX");
		
		if (response.getStatusCode().is2xxSuccessful()) {
			System.out.println("Response status is successful");
			List<StockPrice> stockPricelist = new ArrayList<>();
			TimeSeries priceData = response.getBody();
			for (Map.Entry<String, Price> entry : priceData.getPriceData().entrySet()) {
				StockPrice stockPrice = new StockPrice();
				stockPrice.setDate(sdf.parse(entry.getKey() +"T00:00:00.0000+00:00"));	
				stockPrice.setOpen(entry.getValue().getOpen());
				stockPrice.setHigh(entry.getValue().getHigh());
				stockPrice.setLow(entry.getValue().getLow());
				stockPrice.setClose(entry.getValue().getClose());
				stockPrice.setVolume(entry.getValue().getVolume());
				stockPricelist.add(stockPrice);
			}
			StockPriceDetails stockpriceDetails = new StockPriceDetails();
			stockpriceDetails.setStockPriceList(stockPricelist);
			stockpriceDetails.setSymbol(symbol);
			
			return stockpriceDetails;
		}
		throw new ServiceNotavailableException("Service unavailable");
	}
	
	public Date test() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String dateString="2024-03-14";
		return sdf.parse(dateString +" 00:00:00");
		
		
		
	}

}
