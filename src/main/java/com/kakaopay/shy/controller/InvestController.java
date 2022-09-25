package com.kakaopay.shy.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kakaopay.shy.dto.InvestDto;
import com.kakaopay.shy.model.Product;
import com.kakaopay.shy.model.UserInvest;
import com.kakaopay.shy.service.InvestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InvestController {

	@Autowired
	private InvestService investService;
	
	@PostMapping("/insertProducts")
	@Deprecated
	long insertProduct() {
		return investService.insertProducts();
	}
	
	@PostMapping("/insertUsers")
	@Deprecated
	long insertUsers() {
		return investService.insertUsers();
	}	
	
	@PostMapping("/api/v1/getProductList")
	List<Product> getProductList(HttpServletRequest request) throws UnknownHostException {
        String ip = request.getHeader("X-Forwarded-For");
        
        log.info(">>>> X-FORWARDED-FOR : " + ip);
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
            log.info(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        log.info(">>>> Result : IP Address : "+ip);


		return investService.getProductList();
	}
	
	@PostMapping("/api/v1/doInvest")
	UserInvest doInvest(@RequestHeader(value = "X-USER-ID") Long userId,
            @RequestHeader(value = "X-PRODUCT-ID") Long productId,
            @RequestParam(value = "investAmt", defaultValue = "0") long investAmt) {
		return investService.insertInvest(userId, productId, investAmt);
	}
	
	@PostMapping("/api/v1/getInvestList")
	List<InvestDto> getInvestList(@RequestHeader(value = "X-USER-ID") Long userId) {
		return investService.getInvestList(userId);
	}	
	
}
