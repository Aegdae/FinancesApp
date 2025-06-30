package com.My.FinancesApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String name;
    private String description;
    private double value;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private CategoryExpanse category;

}
