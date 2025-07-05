package com.My.FinancesApp.service;

import com.My.FinancesApp.dto.CreateUserDto;
import com.My.FinancesApp.dto.LoginUserDto;
import com.My.FinancesApp.dto.RecoveryJwtTokenDto;
import com.My.FinancesApp.model.Role;
import com.My.FinancesApp.model.RoleName;
import com.My.FinancesApp.model.User;
import com.My.FinancesApp.repository.RoleRepository;
import com.My.FinancesApp.repository.UserRepository;
import com.My.FinancesApp.security.JwtTokenService;
import com.My.FinancesApp.security.SecurityConfiguration;
import com.My.FinancesApp.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.List;

public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public RecoveryJwtTokenDto authenticationUser (LoginUserDto loginUserDto) {
        try {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword());

            Authentication authentication = authenticationManager.authenticate(authToken);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            String jwt = jwtTokenService.generateToken(userDetails);

            return new RecoveryJwtTokenDto(jwt);

        } catch (Exception ex) {
            throw new RuntimeException("Falha na autenticação: " + ex.getMessage());
        }
    }

    public void createUser(CreateUserDto createUserDto) {

        Role defaultRole = roleRepository.findByName(RoleName.ROLE_COSTUMER)
                .orElseThrow(() -> new RuntimeException("Role padrão não encontrada"));

        User newUser = User.builder()
                .email(createUserDto.getEmail())
                .password(securityConfiguration.passwordEncoder().encode(createUserDto.getPassword()))
                .roles(List.of(defaultRole))
                .build();

        userRepository.save(newUser);
    }
}
