package com.My.FinancesApp.service;

import com.My.FinancesApp.dto.IncomeDto;
import com.My.FinancesApp.model.Income;
import org.springframework.stereotype.Service;
import com.My.FinancesApp.repository.IncomeRepository;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }

    public Income createIncome(IncomeDto incomeDTO) {
        Income income = new Income();
        income.setName(incomeDTO.getName());
        income.setDescription(incomeDTO.getDescription());
        income.setValue(incomeDTO.getValue());
        income.setCategory(incomeDTO.getCategory());

        return incomeRepository.save(income);
    }
}
