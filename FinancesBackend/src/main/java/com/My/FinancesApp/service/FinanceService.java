package com.My.FinancesApp.service;

import com.My.FinancesApp.dto.FinancesBalanceDto;
import com.My.FinancesApp.model.Expanse;
import com.My.FinancesApp.model.Income;
import com.My.FinancesApp.repository.ExpanseRepository;
import com.My.FinancesApp.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FinanceService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ExpanseRepository expanseRepository;


    public BigDecimal getTotalIncome(String userId) {
        List<Income> incomes = incomeRepository.findByUserId(userId);
        return incomes.stream()
                .map(Income::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public BigDecimal getTotalExpanse(String userId) {
        List<Expanse> expanses = expanseRepository.findByUserId(userId);
        return expanses.stream()
                .map(Expanse::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public FinancesBalanceDto totalFinance(String userId) {
        BigDecimal totalIncome = getTotalIncome(userId);
        BigDecimal totalExpanse = getTotalExpanse(userId);
        BigDecimal balance = totalIncome.subtract(totalExpanse);

        return new FinancesBalanceDto(balance);
    }

}

