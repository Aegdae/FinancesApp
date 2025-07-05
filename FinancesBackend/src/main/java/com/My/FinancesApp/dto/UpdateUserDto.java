package com.My.FinancesApp.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class UpdateUserDto {
    public String name;
    public String email;
    public String password;
    public LocalDate bornDate;
}
