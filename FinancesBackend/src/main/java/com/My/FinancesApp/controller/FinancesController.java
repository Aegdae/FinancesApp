package com.My.FinancesApp.controller;

import com.My.FinancesApp.dto.ExpanseDto;
import com.My.FinancesApp.dto.FinancesBalanceDto;
import com.My.FinancesApp.dto.IncomeDto;
import com.My.FinancesApp.dto.TransactionDto;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users/costumer")
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


    @PostMapping("/finances/income")
    public Income addIncome(@RequestBody IncomeDto incomeDTO) {
        return incomeService.createIncome(incomeDTO);
    }

    @GetMapping("/finances/income")
    public List<Income> getIncome(Authentication authentication) {
        String userId = getUserIdFromAuth(authentication);
        return incomeService.getIncomes(userId);
    }

    @PostMapping("/finances/expanse")
    public Expanse addExpanse(@RequestBody ExpanseDto expanseDto) {
        return expanseService.createExpanse(expanseDto);
    }

    @GetMapping("/finances/expanse")
    public List<Expanse> getExpanse(Authentication authentication) {
        String userId = getUserIdFromAuth(authentication);
        return expanseService.getExpanses(userId);
    }


    @GetMapping("/finances/all-transations")
    public List<TransactionDto> getAllTransactions(Authentication authentication) {
        String userId = getUserIdFromAuth(authentication);
        List<Expanse> allExpanses =  expanseService.getExpanses(userId);
        List<Income> allIncomes = incomeService.getIncomes(userId);

        List<TransactionDto> transactions = new ArrayList<>();

        for (Expanse e: allExpanses) {
            TransactionDto expanses = new TransactionDto(
                    e.getId(),
                    e.getName(),
                    e.getValue(),
                    e.getDate(),
                    "EXPANSE"
            );
            transactions.add(expanses);
        }

        for (Income i: allIncomes) {
            TransactionDto incomes = new TransactionDto(
                    i.getId(),
                    i.getName(),
                    i.getValue(),
                    i.getDate(),
                    "INCOME"
            );
            transactions.add(incomes);
        }

        transactions.sort((a, b) -> b.getDate().compareTo(a.getDate()));

        return transactions;
    }


    @GetMapping("/finances/balance")
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
