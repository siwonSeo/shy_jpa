package com.kakaopay.shy.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
public class InvestInsertDto{
    private String title;
    private long totalInvestingAmount;
    private long currentInvestingAmount;
}
