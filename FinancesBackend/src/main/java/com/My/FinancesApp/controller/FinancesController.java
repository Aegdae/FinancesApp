package com.My.FinancesApp.controller;

import com.My.FinancesApp.dto.ExpanseDto;
import com.My.FinancesApp.dto.FinancesBalanceDto;
import com.My.FinancesApp.dto.IncomeDto;
import com.My.FinancesApp.model.Expanse;
import com.My.FinancesApp.model.Income;
import com.My.FinancesApp.security.UserDetailsImpl;
import com.My.FinancesApp.service.ExpanseService;
import com.My.FinancesApp.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.My.FinancesApp.service.IncomeService;

@RestController
@RequestMapping("/users/costumer/finances")
public class FinancesController {

    private final IncomeService incomeService;
    private final ExpanseService expanseService;
    private final FinanceService financeService;

    @Autowired
    public FinancesController(IncomeService incomeService, ExpanseService expanseService, FinanceService financeService){
        this.incomeService = incomeService;
        this.expanseService = expanseService;
        this.financeService = financeService;
    }


    @PostMapping("/income")
    public Income addIncome(@RequestBody IncomeDto incomeDTO) {
        return incomeService.createIncome(incomeDTO);
    }

    @PostMapping("/expanse")
    public Expanse addExpanse(@RequestBody ExpanseDto expanseDto) {
        return expanseService.createExpanse(expanseDto);
    }

    @GetMapping("/balance")
    public ResponseEntity<FinancesBalanceDto> getTotalFinances(Authentication authentication) {
        String userId = getUserIdFromAuth(authentication);
        FinancesBalanceDto dto = financeService.totalFinance(userId);
        return ResponseEntity.ok(dto);
    }

    private String getUserIdFromAuth(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails.getId();
    }
}
