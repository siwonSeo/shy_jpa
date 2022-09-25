package com.kakaopay.shy.model;

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
@NoArgsConstructor
@Entity
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
    private Long userId;
	
	@Column(name = "USER_NAME")
    private String name;
	
	@Column(name = "CRED_DT")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cretDt;
}
