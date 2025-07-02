package com.My.FinancesApp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FinancesBalanceDto {

    private BigDecimal balance;

    public FinancesBalanceDto(BigDecimal balance) {
        this.balance = balance;
    }
}
