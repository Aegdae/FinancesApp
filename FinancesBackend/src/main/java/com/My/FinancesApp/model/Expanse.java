package com.My.FinancesApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "expanses")
@Getter
@Setter
@NoArgsConstructor
public class Expanse {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String name;
    private String description;
    private BigDecimal value;
    private Instant date;
    @Enumerated(EnumType.STRING)
    private CategoryExpanse category;

}
