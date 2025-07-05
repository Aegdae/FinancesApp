package com.My.FinancesApp.controller;

import com.My.FinancesApp.dto.CreateUserDto;
import com.My.FinancesApp.dto.UpdateUserDto;
import com.My.FinancesApp.model.Role;
import com.My.FinancesApp.model.RoleName;
import com.My.FinancesApp.model.User;
import com.My.FinancesApp.repository.RoleRepository;
import com.My.FinancesApp.service.AdminService;
import com.My.FinancesApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUser();
        return ResponseEntity.ok(users);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<Void> createUserAdmin(@RequestBody CreateUserDto createUserDto) {
        adminService.createUserAdmin(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/update")
    public ResponseEntity<Void> updateUser(@Valid @RequestParam UpdateUserDto updateUserDto) {
        try {
            userService.updateUser(updateUserDto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam String email) {
        userService.deleteUser(email);
        return ResponseEntity.ok().build();
    }


}
