package com.My.FinancesApp.dto;

import lombok.Data;
import com.My.FinancesApp.model.CategoryExpanse;


@Data
public class ExpanseDto {
    private String name;
    private String description;
    private double value;
    private CategoryExpanse category;

}
