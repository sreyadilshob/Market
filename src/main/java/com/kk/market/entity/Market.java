package com.kk.market.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Market {
	@JsonProperty("Symbol")
	String symbol;
	@JsonProperty("Name")
	String name;
	@JsonProperty("Description")
	String description;
	@JsonProperty("Sector")
	String sector;
	@JsonProperty("SharesOutstanding")
	String sharesOutstanding;
	@JsonProperty("RevenueTTM")
	String revenueTTM;
	@JsonProperty("GrossProfitTTM")
	String grossProfitTTM;
	

	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getSharesOutstanding() {
		return sharesOutstanding;
	}
	public void setSharesOutstanding(String sharesOutstanding) {
		this.sharesOutstanding = sharesOutstanding;
	}
	public String getRevenueTTM() {
		return revenueTTM;
	}
	public void setRevenueTTM(String revenueTTM) {
		this.revenueTTM = revenueTTM;
	}
	public String getGrossProfitTTM() {
		return grossProfitTTM;
	}
	public void setGrossProfitTTM(String grossProfitTTM) {
		this.grossProfitTTM = grossProfitTTM;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
