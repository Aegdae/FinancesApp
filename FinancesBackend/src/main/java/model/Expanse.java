package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

enum CategoryExpanse {
    FOOD,
    HOUSING,
    TRANSPORTATION,
    LEISURE,
    HEALTH,
    OTHERS
}

@Entity
@Getter
@Setter
@Table( name = "expanses")
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
