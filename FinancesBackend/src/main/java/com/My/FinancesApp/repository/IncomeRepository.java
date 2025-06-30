package com.My.FinancesApp.repository;

import com.My.FinancesApp.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, String> {
}
