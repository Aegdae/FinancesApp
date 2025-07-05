package com.My.FinancesApp.controller;

import com.My.FinancesApp.dto.CreateUserDto;
import com.My.FinancesApp.dto.LoginUserDto;
import com.My.FinancesApp.dto.RecoveryJwtTokenDto;
import com.My.FinancesApp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.My.FinancesApp.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser(@RequestBody LoginUserDto loginUserDto) {
        RecoveryJwtTokenDto token = authService.authenticationUser(loginUserDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto createUserDto) {
        authService.createUser(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
