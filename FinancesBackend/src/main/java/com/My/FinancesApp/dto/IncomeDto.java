package com.My.FinancesApp.dto;

import lombok.Data;
import com.My.FinancesApp.model.CategoryIncome;


@Data
public class IncomeDto {

    private String name;
    private String description;
    private double value;
    private CategoryIncome category;
}
