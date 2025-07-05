package com.My.FinancesApp.controller;

import com.My.FinancesApp.dto.UpdateUserDto;
import com.My.FinancesApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/costumer")
public class UserController {

    @Autowired
    private UserService userService;

    @PatchMapping("/update")
    public ResponseEntity<Void> updateUser(@Valid @RequestBody UpdateUserDto updateUserDto){
        try {
            userService.updateUser(updateUserDto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam String email) {
        try {
            userService.deleteUser(email);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
