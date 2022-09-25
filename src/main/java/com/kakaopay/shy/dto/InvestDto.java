package com.kakaopay.shy.dto;

import java.time.LocalDateTime;

import com.kakaopay.shy.model.UserInvest;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
public class InvestDto{
	private Long productId;
    private String title;
    private long totalInvestingAmount;
    private long userInvestingAmount;
    private LocalDateTime cretDt;
    public InvestDto(UserInvest userInvest) {
		this.productId = userInvest.getProductId();
		this.title = userInvest.getProduct().getTitle();
		this.totalInvestingAmount = userInvest.getProduct().getTotalInvestingAmount();
		this.userInvestingAmount = userInvest.getUserInvestingAmount();
		this.cretDt = userInvest.getCretDt();
	}    
}
