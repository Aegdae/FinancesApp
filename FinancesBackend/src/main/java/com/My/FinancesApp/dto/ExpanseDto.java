package com.My.FinancesApp.dto;

import com.My.FinancesApp.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import com.My.FinancesApp.model.CategoryExpanse;

import java.math.BigDecimal;


@Data
public class ExpanseDto {

    private String name;
    private String description;
    private BigDecimal value;
    private CategoryExpanse category;

}
