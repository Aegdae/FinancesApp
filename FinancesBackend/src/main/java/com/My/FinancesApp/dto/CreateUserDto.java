package com.My.FinancesApp.dto;

import lombok.Data;
import lombok.Getter;
import com.My.FinancesApp.model.RoleName;

@Data
@Getter
public class CreateUserDto {
    String email;
    String password;
    RoleName role;
}


