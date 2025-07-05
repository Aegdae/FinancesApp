package com.My.FinancesApp.repository;

import com.My.FinancesApp.model.Role;
import com.My.FinancesApp.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(RoleName role);
    boolean existsByName(RoleName role);
}
