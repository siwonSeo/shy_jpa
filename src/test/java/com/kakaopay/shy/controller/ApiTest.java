package com.kakaopay.shy.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kakaopay.shy.service.InvestService;

@SpringBootTest
public class ApiTest {
	boolean initYn = false;
	
	@Autowired
	private InvestService investService;
	
    void setData() {
    	investService.insertProducts();
    	investService.insertUsers();
    }
	  
    @Test
    public void getProductList() throws Exception {
    	setData();
    	assertThat(investService.getProductList()).isNotNull();
    }
    
    @Test
    public void insertInvest() throws Exception {
    	Long userId = 1L;
    	Long productId = 2L;
    	Long userInvestingAmount = 990000L;
    	assertThat(investService.insertInvest(userId,productId,userInvestingAmount)).isNotNull();
    	assertThat(investService.insertInvest(userId,productId,userInvestingAmount)).isNotNull();
    }
    
    @Test
    public void getInvestList() throws Exception {
    	Long userId = 1L;
    	assertThat(investService.getInvestList(userId)).isNotNull();
    }
    
}
