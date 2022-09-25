package com.kakaopay.shy.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class UserInvestPk implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "USER_ID")
    private Long userId;
	
	@Column(name = "PRODUCT_ID")
    private Long productId;
}
