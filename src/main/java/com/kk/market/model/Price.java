package com.kk.market.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {

	@JsonProperty("1. open")
	private Double open;
	@JsonProperty("2. high")
	private Double high;
	@JsonProperty("3. low")
	private Double low;
	@JsonProperty("4. close")
	private Double close;
	@JsonProperty("5. volume")
	private Double volume;

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

}
