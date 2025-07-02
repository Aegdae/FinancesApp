package com.My.FinancesApp.repository;

import com.My.FinancesApp.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, String> {
    List<Income> findByUserId(String id);
}
