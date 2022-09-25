package com.kakaopay.shy.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@IdClass(UserInvestPk.class)
public class UserInvest{
	@Id
	@Column(name = "USER_ID")
    private Long userId;
	
//	@Id
	@Column(name = "PRODUCT_ID")
    private Long productId;
	
	@Column(name = "USER_INVESTING_AMOUNT")
    private long userInvestingAmount;
	
	@Column(name = "CRED_DT")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cretDt;
	
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "PRODUCT_ID" , insertable = false, updatable = false)
    private Product product;
    
}
