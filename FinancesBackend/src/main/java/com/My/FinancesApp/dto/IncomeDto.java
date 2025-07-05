package com.My.FinancesApp.dto;

import lombok.Data;
import com.My.FinancesApp.model.CategoryIncome;

import java.math.BigDecimal;
import java.time.Instant;


@Data
public class IncomeDto {

    private String name;
    private String description;
    private BigDecimal value;
    private Instant date;
    private CategoryIncome category;
    private String userId;
}
