package com.My.FinancesApp.controller;

import com.My.FinancesApp.dto.IncomeDto;
import com.My.FinancesApp.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.My.FinancesApp.service.IncomeService;

@RestController
@RequestMapping("/finances")
public class IncomeController {

    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService){
        this.incomeService = incomeService;
    }

    @PostMapping("/income")
    public Income addIncome(@RequestBody IncomeDto incomeDTO) {
        return incomeService.createIncome(incomeDTO);
    }

}
