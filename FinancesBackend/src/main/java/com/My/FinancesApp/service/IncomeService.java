package com.My.FinancesApp.service;

import com.My.FinancesApp.dto.IncomeDto;
import com.My.FinancesApp.model.Income;
import com.My.FinancesApp.model.User;
import com.My.FinancesApp.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.My.FinancesApp.repository.IncomeRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }

    public Income createIncome(IncomeDto incomeDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String userId = userDetails.getId();

        Income income = new Income();
        income.setName(incomeDTO.getName());
        income.setDescription(incomeDTO.getDescription());
        income.setValue(incomeDTO.getValue());
        income.setDate(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant());
        income.setCategory(incomeDTO.getCategory());

        User user = new User();
        user.setId(userId);
        income.setUser(user);

        return incomeRepository.save(income);
    }
}
