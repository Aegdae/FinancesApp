package com.My.FinancesApp.repository;

import com.My.FinancesApp.model.Expanse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpanseRepository extends JpaRepository<Expanse, String> {
}
