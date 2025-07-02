package com.My.FinancesApp.repository;

import com.My.FinancesApp.model.Expanse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpanseRepository extends JpaRepository<Expanse, String> {
    List<Expanse> findByUserId(String id);
}
