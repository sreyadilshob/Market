package com.kk.market.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSeries {

	@JsonProperty("Time Series (Daily)")
	Map<String, Price> priceData;

	public Map<String, Price> getPriceData() {
		return priceData;
	}

	public void setPriceData(Map<String, Price> priceData) {
		this.priceData = priceData;
	}
	
	
}
