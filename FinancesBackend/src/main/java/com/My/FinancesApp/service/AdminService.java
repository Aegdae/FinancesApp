package com.My.FinancesApp.service;

import com.My.FinancesApp.dto.CreateUserDto;
import com.My.FinancesApp.model.Role;
import com.My.FinancesApp.model.RoleName;
import com.My.FinancesApp.model.User;
import com.My.FinancesApp.repository.RoleRepository;
import com.My.FinancesApp.repository.UserRepository;
import com.My.FinancesApp.security.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    public void createUserAdmin(CreateUserDto createUserDto) {

        Role defaultRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Role padrão não encontrada"));

        User newUser = User.builder()
                .email(createUserDto.getEmail())
                .password(securityConfiguration.passwordEncoder().encode(createUserDto.getPassword()))
                .roles(List.of(defaultRole))
                .build();

        userRepository.save(newUser);
    }
}
