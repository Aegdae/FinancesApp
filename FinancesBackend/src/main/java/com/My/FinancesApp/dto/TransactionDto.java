package com.My.FinancesApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {

    private String id;
    private String name;
    private BigDecimal value;
    private Instant date;
    private String type;
}
