package com.My.FinancesApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private RoleName name;
}
