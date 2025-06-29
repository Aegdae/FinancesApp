package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

enum CategoryIncome {
    SALARY,
    SELLS
}

@Entity
@Getter
@Setter
@Table( name = "income")
public class Income {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private double value;
    @Enumerated(EnumType.STRING)
    private CategoryIncome category;
}
