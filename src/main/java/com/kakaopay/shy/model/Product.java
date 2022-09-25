package com.kakaopay.shy.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.kakaopay.shy.code.Status;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
public class Product{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
    private Long productId;
	
	@Column(name = "TITLE")
    private String title;
	
	@Column(name = "TOTAL_INVESTING_AMOUNT")
    private long totalInvestingAmount;
	
	@Column(name = "CURRENT_INVESTING_AMOUNT")
    private long currentInvestingAmount;
	
	@Column(name = "STARTED_AT")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startedAt;
	
	@Column(name = "FINISHED_AT")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finishedAt;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    
	@Column(name = "INVEST_COUNT")
    private long investCount;
	
	public void updateInvestCount() {
		this.investCount++;
	}
	public void doInvest(long currentInvestingAmount) {
		this.currentInvestingAmount += currentInvestingAmount;
	}
}
