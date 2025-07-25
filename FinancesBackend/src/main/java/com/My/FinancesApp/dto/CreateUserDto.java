package com.My.FinancesApp.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.Getter;
import com.My.FinancesApp.model.RoleName;

import java.time.LocalDate;

@Data
@Getter
public class CreateUserDto {
    public String name;
    @Email
    public String email;
    public String password;
    public LocalDate bornDate;
    public RoleName role;
}


