package com.kk.market.service;

import java.text.ParseException;import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MarketServiceImplTest {
	@InjectMocks
	MarketServiceImpl marketService;
	
	@Test
	public void Test_test1() throws ParseException {
		Date newdata = new Date();
		System.out.println(newdata);
	   System.out.println(marketService.test());
	}

}
