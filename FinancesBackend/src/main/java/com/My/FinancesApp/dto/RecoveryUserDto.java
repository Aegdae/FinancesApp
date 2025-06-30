package com.My.FinancesApp.dto;

import lombok.Data;
import com.My.FinancesApp.model.Role;

import java.util.List;

@Data
public class RecoveryUserDto {
    String id;
    String email;
    List<Role> roles;
}
